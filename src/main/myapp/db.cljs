(ns myapp.db
  (:require
   [re-frame.core :as rf]))

(def app-db
  "Set any initial state"
  {})

(rf/reg-event-fx
 ::init-db
 (fn [_ _]
  {:db app-db}))
