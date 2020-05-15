(ns myapp.router
  (:require
   [re-frame.core :as rf]
   [reitit.coercion.spec :as rss]
   [reitit.frontend]
   [reitit.frontend.controllers :as rfc]
   [reitit.frontend.easy :as rfe]
   [myapp.router.routes :as routes]))

(defn href
  "Return relative url for given route.
  Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rfe/href k params query)))

(rf/reg-fx
 ::navigate!
 (fn [route]
   (apply rfe/push-state route)))

(rf/reg-event-fx
  ::navigate
  (fn [_ [_ & route]]
    {::navigate! route}))

(rf/reg-sub
 ::current-route
 (fn [db]
   (::current-route db)))

(rf/reg-event-db
 ::navigated
 (fn [db [_ new-match]]
   (let [old-match   (::current-route db)
         controllers (rfc/apply-controllers
                      (:controllers old-match) new-match)]
     (assoc db ::current-route
            (assoc new-match :controllers controllers)))))

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [::navigated new-match])))

(def router
  (reitit.frontend/router
   routes/routes
   {:data {:coercion rss/coercion}}))

(defn init-routes! []
  (rfe/start!
   router
   on-navigate
   {:use-fragment true}))
