(ns NEW.conditionals)

(defn CondIf
  []
  (println "\nCondIf:")
  (if (= 5 5)
    (println "equal")
    (println "not equal")))

(CondIf)

(defn CondIfDo
  []
  (println "Cond If Do:")
  (if (=  5 5)
    (do (println "Equal first statement")
        (println "equal second statement"))
    (do (println "not equal first statement")
        (println "Not Equal second statement"))
    ))

(CondIfDo)

(defn CondNestedIf
  []
  (println "Condition Nested If")
  (if (and (= 5 2) (or (= 2 2) (not true)))
    (println "True")
    (println "False"))
  )
(CondNestedIf)

(defn CondCase
  [pet]
  (println "CondCase:")
  (case pet
    "cat" (println "I have cat")
    "dog" (println "I have dog")
    "fish" (println "I have fish"))
  )
(CondCase "cat")
(CondCase "dog")
(CondCase "fish")

(defn CondCond
  [amount]
  (println "CondCond:")
  (cond
    (<= amount 2) (println "Few")
    (<= amount 10) (println "several")
    (<= amount 100) (println "Many")
    :else (println "Loads"))
  )

(CondCond 1)
(CondCond 5)
(CondCond 14)
(CondCond 111)
