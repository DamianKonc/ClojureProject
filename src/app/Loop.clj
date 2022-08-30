(ns clojureproject.Loop)

(defn Loop
  []
  (println "LOOP:")
  (loop [x 0]
    (when (< x 10)
      (println x)
      (recur (inc x)
             )
      )
    )

  )
(Loop)

(defn DoTimes
  []
  (println "Do Times:")
  (dotimes [x 10]
    (println x)
    )
  )
(DoTimes)

(defn WhileDo
  [count]
  (println "While Do")
  (def x (atom 0))
  (while (< @x count)
    (do
      (println @x)
      (swap! x inc)))
  )
(WhileDo 10)

(defn DoSeq
  [seq]
  (println "DO SeQ")
  (doseq [x seq]
    (println (inc x))
    )
  )
(DoSeq [1 2 3])
