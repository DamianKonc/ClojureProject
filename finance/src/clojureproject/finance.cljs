(ns ^:figwheel-hooks clojureproject.finance
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [clojure.edn :as edn]))



;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:first-number 0
                          :second-number 0 
                          :sum 0}))

(defn get-app-element []
  (gdom/getElement "app"))

(defn navigation-el [text]
  [:li {:class "navigation__list_el"} text]
  )

(defn navigation []
  [:nav {:class "navigation"}
   [:ul {:class "navigation__list"}
    [navigation-el "Menu1"]
    [navigation-el "Menu2"]
    [navigation-el "Menu3"]
    [navigation-el "Menu4"]
    ]])

(defn header []
  [:div {:class "wrapper"}
   [:div {:class "halo"}
    [:h1  {:class "header"} 
     [:a {:class "header__logo" :href "./"} "Welcome"]
    ]
    [navigation]
   ]
  ])

(defn get-forecast! []                             
   (swap! app-state assoc :sum(->  ( + (edn/read-string(:first-number @app-state )) (edn/read-string(:second-number @app-state ))))))


(defn body []
  [:section
   [:div {:class "add"}
    [:input 
     { 
      :type "number"
      :class "number-Input"
      :value (:first-number @app-state)
      :on-change #(swap! app-state assoc :first-number (-> % .-target .-value))
      }] 
    "+" 
    [:input
     {
      :type "number"
      :class "number-Input"
      :value (:second-number @app-state)
      :on-change #(swap! app-state assoc :second-number (-> % .-target .-value))
     }] 
    [:button {:on-click get-forecast!} "Go"]
     [:div (:sum @app-state)]]
    
   
  ]
  
  )

(defn app []
  [:div
    [header]
    [body]
  ]
 
)

(defn mount [el]
  (rdom/render [app] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))
(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element)
)
