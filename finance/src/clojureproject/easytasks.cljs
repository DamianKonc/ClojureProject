(ns clojureproject.easytasks)


(def trainingfunction
  (fn [message]
  (js/alert (.toUpperCase (str message "!!!!!!!!!!!!!!!!")))))

(trainingfunction "test")

(defn easy-tasks []
  [:h1 "Easy tasks"])