(ns ^:figwheel-hooks clojureproject.finance
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]))

(println "This text is printed from src/clojureproject/finance.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

(defn navigation []
  [:nav {:class "navigation"}
   [:ul {:class "navigation__list"}
    [:li {:class "navigation__list_el"} "Menu1"]
    [:li {:class "navigation__list_el"} "Menu2"]
    [:li {:class "navigation__list_el"} "Menu3"]
    [:li {:class "navigation__list_el"} "Menu4"]]])

(defn hello-world []
  [:div {:class "wrapper"}
   [:div {:class "halo"}
    [:h1  {:class "header"} 
     [:a {:class "header__logo" :href "./"} (:text @app-state)]
    ]
    [navigation]
    ]
   
   [:p "Edit this in src/clojureproject/finance.cljs and watch it change!"]])

(defn mount [el]
  (rdom/render [hello-world] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))
(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element)
)
