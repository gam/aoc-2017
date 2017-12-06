(ns advent-of-code.day-2
  (require [clojure.string :refer [split split-lines]]))

(defn parse-line [line]
  (->> (split line #"\s+")
       (map #(Integer/parseInt %))
       sort))

(defn parse [input]
  (->> input
       split-lines
       (map parse-line)))

(defn find-difference [numbers]
  (- (last numbers) (first numbers)))

(defn solve-1 [input]
  (->> input
       parse
       (map find-difference)
       (apply +)))

(defn find-clean-division [numbers]
  (for [x numbers
        y numbers
        :when (and (not= x y)
                   (zero? (mod y x)))]
    (/ y x)))

(defn solve-2 [input]
  (->> input
       parse
       (map find-clean-division)
       flatten
       (apply +)))
