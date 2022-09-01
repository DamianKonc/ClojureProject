(ns ^:figwheel-hooks learn-cljs.weather
    (:require
     [goog.dom :as gdom]
     [reagent.dom :as rdom]
     [reagent.core :as r]))

(defonce app-state (r/atom {:title "WhichWeather"
                            :postal-code ""
                            :temperatures {:today {:label "Today"
                                                   :value nil}
                                           :tomorrow {:label "Tomorrow"
                                                      :value nil}}}))

(defn  title[]
  [:h1(:title @app-state)])

(defn temperature [temp]
  [:div{:class "temperature"}
   [:div {:class "value"}
    (:value temp)]
   [:h2 (:label temp)]])

(defn postal-code []
  [:div {:class "postal-code"}
   [:h3 "Enter your postal code"]
   [:input {:type "text"
            :placeholder "Postal Code"
            :value (:postal-code @app-state)}]
   [:button "Go"]])

(defn app []
  [:div {:class "app"}
   [title]
   [:div {:class "temperatures"}
    (for [temp (vals (:temperatures @app-state))]
      [temperature temp])]
   [postal-code]])



(defn mount-app-element []                                 ;; <4>
  (rdom/render [app] (gdom/getElement "app")))

(defn ^:after-load on-reload []                            ;; <4>
  (mount-app-element))