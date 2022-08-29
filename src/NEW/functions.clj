(ns NEW.functions
  (:gen-class))

((defn -main
  "first function"
  []
  (println "my name is John")
   (println "loving clojure so far")
   ( + 2 5)))

#(println "hello" %)
#(println %1 %2 %&)
(println "dupa")

(def increment (fn [x] (+ x 1)))

(defn increment_set
  []
  (map increment [1 2 3]))