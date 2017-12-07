(ns advent-of-code.day-5
  (require [clojure.string :refer [split-lines]]))

(defn build-dataset []
  (->> "resources/day-5-input.txt"
       slurp
       split-lines
       (mapv #(Integer/parseInt %))))

(declare ^:dynamic update-function)

(defn resolve-maze [steps index path]
  (if (>= index (count path))
    steps
    (let [value (get path index)]
      (recur (inc steps)
             (+ index value)
             (assoc path index (update-function value))))))

(defn- dec-or-inc [value]
  (if (> value 2)
    (dec value)
    (inc value)))

(defn solve-1 [input]
  (binding [update-function inc]
    (resolve-maze 0 0 input)))

(defn solve-2 [input]
  (binding [update-function dec-or-inc]
    (resolve-maze 0 0 input)))
