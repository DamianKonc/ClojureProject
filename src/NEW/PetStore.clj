(ns NEW.PetStore)
(defn petToHumanAnge
  "this function returns the age of a pet in human years"
  [x]
  (def petStore {'dog 7, 'cat 5, 'goldfish 10})
  (get petStore x))

(defn age
  "Returns the age of a pet"
  [petName petType petAge]
  (def ratio (petToHumanAnge petType))
  (println petName "is" (* ratio petAge) "years old in human years"))

(age "Fido" 'dog 4)
(age "Fifi" 'cat 2)
(age "Bubbles" 'goldfish 10)