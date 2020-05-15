(ns myapp.navbar
  (:require
   [reitit.core :as rc]
   [myapp.router :as router]))

(defn nav [{:keys [router current-route]}]
  [:ul
   (for [route-name (rc/route-names router)
         :let       [route (rc/match-by-name router route-name)
                     text (-> route :data :link-text)]]
     [:li {:key route-name}
      (when (= route-name (-> current-route :data :name))
        "> ")
      [:a {:href (router/href route-name)} text]])])
