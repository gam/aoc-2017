(ns advent-of-code.day-4
  (require [clojure.string :refer [split split-lines]]))

(def ^:private puzzle-input "resources/day-4-input.txt")

(defn split-line [line]
  (split line #"\s+"))

(defn build-dataset []
  (->> puzzle-input
       slurp
       split-lines
       (map split-line)))

(defn all-distinct? [words]
  (= (count words)
     (count (distinct words))))

(defn all-distinct-non-anagrams? [words]
    (all-distinct? (map sort words)))

(defn solve-for [predicate]
  (count (filter predicate (build-dataset))))

(defn solve-1 []
  (solve-for all-distinct?))

(defn solve-2 []
  (solve-for all-distinct-non-anagrams?))

