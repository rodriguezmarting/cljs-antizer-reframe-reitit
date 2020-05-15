(ns myapp.home
  (:require
    [antizer.reagent :as ant]
    [cljs.spec.alpha :as s]))

(defn sum [a b]
  (+ a b))

(s/fdef sum
  :args (s/cat :a number?
               :b number?)
  :ret number?)

(defn index
  []
  [:div
   [:h1 "Hello from Home page"]
   [ant/button
   {:on-click #(do (ant/message-info "Hello from Ant!")
                   (js/console.log (sum 1 "hola")))}
    "Click me"]]) 

