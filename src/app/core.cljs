(ns app.core
  (:require [reagent.core :as r]
            [reagent.dom :as rd]))
(defonce conter-state (r/atom 0))

(defn handle-increment []
  (swap! conter-state inc))
(defn handle-decrement []
  (if (> @conter-state 0) (swap! conter-state dec) ()))

(defn handle-reset []
  (reset! conter-state 0))

(defn counter []
  [:div.container
   [:h1.header (str "Counter: " @conter-state)]
   [:button.btn.btn-increment {:on-click handle-increment}"+"]
   [:button.btn.btn-increment {:on-click handle-decrement} "-"]
   [:button.btn.btn-increment {:on-click handle-reset} "Reset"]])

(def dom-node (js/document.getElementById "app"))

(defn ^:dev/after-load start []
  (rd/render [counter] dom-node))

(defn ^:export init []
  (start))