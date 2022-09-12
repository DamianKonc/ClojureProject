(ns ^:figwheel-hooks clojureproject.finance
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [clojure.edn :as edn]
   [ajax.core :refer [GET POST json-response-format]]
  [clojureproject.easytasks :refer [easy-tasks]]))

(defonce app-state (atom nil))



(defn handler [response]
  (reset! app-state response))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happend: " status " " status-text)))

(defn get-pokemons! []
 (GET "https://pokeapi.co/api/v2/pokemon?limit=20"
   :handler handler
   :response-format (json-response-format {:keywords true})
   :error-handler error-handler))

(get-pokemons!)

(defn get-app-element []
  (gdom/getElement "app"))


(def items `(1 2 3 4 5))
(defn printing-items []
  (for [item items]
  (println item))
)
(printing-items)
;; sss

(defn app []
  [:div
   [:ul
   (for [el items]
     [:li {:key el} el])]
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


