(ns clojureproject.easytasks)


;; (def trainingfunction
;;   (fn [message]
;;   (println (.toUpperCase (str message "!!!!!!!!!!!!!!!!")))))

;; (trainingfunction "test")

;; (def chooseDesert 
;;   (let [desserts ["Apple Pie" "Ice Cream Sandwiches" "Chocolates" "Berry Buckle"]
;;       favorite-index 1
;;       favorite-dessert (get desserts favorite-index)]
;;   (println "All desserts are great, but I like" favorite-dessert "the best")))

;; chooseDesert

;; (let [[eat-now & eat-later] ["nachos" "salad" "apples" "yogurt"]]
;;   (println "Please pass the" eat-now)
;;   (println "I'm saving these for later:" eat-later))

;; (let [{:keys [x y z]} {:x 534 :y 497 :z -73}]
;;   (println "x = " x "| y = " y "| z = " z))

;;  (let [[one two & the-rest] [1 10 3 4 6]]
;;   the-rest
;;    (println one two the-rest))

;; (do (dorun  
;;       (for [i (range 10)]
;;         (println i)))
;;     (println "Done")) 


;; (def samples [[8 12 4]
;;               [9 3 3 6]
;;               [11 4]])

;; (def result-1 (map first samples))

;; (println result-1)

;; (def result-2 (map dec result-1))
 
;;  (println result-2)

;; (def tax-rate 0.079)

;; (defn add-sales-tax [cart-item]
;;   (let [{:keys [price]} cart-item]
;;     (assoc cart-item :sales-tax (* price tax-rate))))

;; (def t-shirt {:name "T-shirt" :price 10})

;; (println t-shirt)

;; (def taxed-tshirt (add-sales-tax {:name "T-shirt" :price 10}))

;; (println taxed-tshirt)

;; (def cart-item
;;   `({:name "silicone shuffle" :price 11}
;;     {:name "wood" :price 14.22}
;;     {:name "gold" :price 154.12}))

;; (println cart-item)

;; (def taxed-items (map add-sales-tax cart-item))

;; (println taxed-items)

;; Create a seq of words
;; (def words (clojure.string/split
;;             "it was the best of times it was the worst of times"
;;             #" "))

;; (defn count-words [counts word]
;;   (update-in counts [word] #(inc (or % 0))))

;; (def word-counts (reduce count-words {} words))

;; (println word-counts)

;; (println (assoc-in {} [:foo :bar :baz] "quux"))

;; (println (assoc-in {:tag "ul"
;;            :children [{:tag "li"
;;                        :id "first"}
;;                       {:tag "li"
;;                        :id "second"}]}
;;           [:children 1 :class]
;;           "last-item"))

;; (println (update-in {} [:foo :bar] inc))


(defn easy-tasks []
  [:h1 "Easy tasks"])