(ns clojureproject.Sequences)

(defn Seq
  []
  (def colors (seq ["red" "green" "blue"]))
  (println colors)

  (println (cons "yellow" colors))
  (println (cons colors "yellow"))

  (println (conj colors "purple"))
  (println (conj ["red" "green" "blue"] "purple" ))

  (println (concat colors (seq ["back" "white"])))
  (println (reverse colors))
  (println (first colors))
  (println (rest colors))
  (println (last colors))

  (print (sort (seq [1 2 3 5 2 2 4 3 4 6])))
  )

(Seq)