(ns advent-of-code.day-5
  (require [clojure.string :refer [split-lines]]))

(defn resolve-maze [steps index path]
  (if (>= index (count path))
    steps
    (let [value (get path index)]
      (recur (inc steps)
             (+ index value)
             (assoc path index (inc value))))))

(defn resolve-maze-2 [steps index path]
  (if (>= index (count path))
    steps
    (let [value (get path index)
          new-value (if (> value 2) (dec value) (inc value))]
      (recur (inc steps)
             (+ index value)
             (assoc path index new-value)))))

(defn build-dataset-2 []
  (apply vector (map #(Integer/parseInt %) (split-lines (slurp "resources/day-5-input.txt")))))

(defn build-dataset []
  (mapv #(Integer/parseInt %) (split-lines (slurp "resources/day-5-input.txt"))))

(defn solve-1 [input]
  (resolve-maze 0 0 input))

(defn solve-2 [input]
  (resolve-maze-2 0 0 input))
