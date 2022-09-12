(ns ^:figwheel-hooks clojureproject.finance
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [clojure.edn :as edn]
   [ajax.core :refer [GET POST]]
  [clojureproject.easytasks :refer [easy-tasks]]))

(defonce app-state (atom :pokemons []))

(defn get-pokemons! []
 (GET "https://pokeapi.co/api/v2/pokemon/35/"
   :handler (println "dziala")
   :error-handler (println "Nie działa")))

(get-pokemons!)

(defn get-app-element []
  (gdom/getElement "app"))

(defn app []
  [:div
    "EEEEEEEE"
  [ easy-tasks]
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


