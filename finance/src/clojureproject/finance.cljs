(ns ^:figwheel-hooks clojureproject.finance
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [clojure.edn :as edn]
  [clojureproject.easytasks :refer [easy-tasks]]))



;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:first-number 0
                          :second-number 0 
                          :sum 0}))
(def fucking-list
  `(1 2 3 4 5 6 7)
  )

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

(defn sum-numbers []     
  (swap! app-state assoc 
         :sum(->  ( + 
                   (:first-number @app-state ) 
                   (:second-number @app-state )
                  )
             )
  (swap! app-state assoc :first-number (-> 0))
  (swap! app-state assoc :second-number (-> 0))
  )
)


(defn hello-component [name]
  [:p "hello, " name "!"])

(defn lister [items]
  [:ul
   (for [item items]
     ^{:key item} [:li "Item" item])])


(defn numberInput [changeValue]
    [:input {:type "number" :value (changeValue @app-state) 
          :on-change (fn [e]
                        (let [new-value (js/parseInt (-> e .-target .-value))]
                         (swap! app-state assoc changeValue new-value)))}]
  
  )


(defn body []
  [:section
   [:div {:class "add"}
    [numberInput :first-number]
    "+" 
    [numberInput :second-number]
    [:button {:on-click sum-numbers} "="]
     [:div (:sum @app-state)]]
      [hello-component "Mirek"]
      [lister fucking-list]
  ])
;; ////////////
(defn date-input []
  [:div.input-wrapper                                      ;; <1>
    [:label "Day"]
    [:input {:type "date"}]])                              ;; <2>

(defn time-input []
  [:div.input-wrapper
    [:label "Time (minutes)"]
    [:input {:type "number" :min 0 :step 1}]])

(defn submit-button []
  [:div.actions
    [:button {:type "submit"} "Submit"]])

(defn form []
  [:form.input-form
    [date-input]                                           ;; <3>
    [time-input]
    [submit-button]])



;; /////////////

(defn app []
  [:div
    [header]
    [body]
   [form]
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


