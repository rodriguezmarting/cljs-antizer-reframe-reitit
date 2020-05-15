(ns myapp.app
  (:require
    [cljs.repl :as repl]
    [cljs.spec.alpha :as s]
    [cljs.spec.test.alpha :as st]
    [devtools.core :as devtools]
    [expound.alpha :as expound]
    [re-frame.core :as rf]
    [reagent.dom :as rdom]
    [reitit.frontend :as reitit-front]
    [reitit.frontend.easy :as rfe]
    [myapp.db :as db]
    [myapp.navbar :as navbar]
    [myapp.router :as router]))

(def devtools-error-formatter
  "Uses cljs.repl utilities to format ExceptionInfo objects in Chrome devtools console."
  #js{:header
      (fn [object _config]
        (when (instance? ExceptionInfo object)
          (let [message (some->> (repl/error->str object)
                                 (re-find #"[^\n]+"))]
            #js["span" message])))
      :hasBody (constantly true)
      :body (fn [object _config]
              #js["div" (repl/error->str object)])})

;; Enables expound to work in the browser
(defonce _
  (some-> js/window.devtoolsFormatters
          (.unshift devtools-error-formatter)))


(defn app [{:keys [router]}]
  (let [current-route @(rf/subscribe [::router/current-route])]
    [:div
     [navbar/nav {:router router
                  :current-route current-route}]
     (when current-route
       [(-> current-route :data :view)])]))

(def debug? ^boolean goog.DEBUG)

(defn dev-setup []
  (when debug?
    (do
      (devtools/install! [:formatters :hints])
      (enable-console-print!))))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (router/init-routes!)
  (rdom/render [app {:router router/router}]
               (js/document.getElementById "app")))

(defn ^:export init! []
  (s/check-asserts true)
  (st/instrument)
  (set! s/*explain-out* expound/printer)
  (rf/dispatch-sync [::db/init-db])
  (dev-setup)
  (mount-root))
