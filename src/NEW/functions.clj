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

(def increment (fn [x] (+ x 1)))

(defn increment_set
  [x]
  (map increment x))

((defn DataTypes []
  (def a 1)
  (def b 1.25)

   (println a)
   (println b)
  ))

(DataTypes)