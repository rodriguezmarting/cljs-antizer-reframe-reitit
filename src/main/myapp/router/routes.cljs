(ns myapp.router.routes
  (:require
   [myapp.home :as home]
   [myapp.sub-page1 :as sub-page1]
   [myapp.sub-page2 :as sub-page2]))

(def routes
  ["/"
   [""
    {:name      ::home
     :view      home/index
     :link-text "Home"
     :controllers
     [{;; Do whatever initialization needed for home page
       ;; I.e (rf/dispatch [::events/load-something-with-ajax])
       :start (fn [& params](js/console.log "Entering home page"))
       ;; Teardown can be done here.
       :stop  (fn [& params] (js/console.log "Leaving home page"))}]}]
   ["sub-page1"
    {:name      ::sub-page1
     :view      sub-page1/index
     :link-text "Sub page 1"}]
   ["sub-page2"
    {:name      ::sub-page2
     :view      sub-page2/index
     :link-text "Sub page 2"}]])
