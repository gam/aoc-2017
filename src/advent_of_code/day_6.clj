(ns advent-of-code.day-6
  (require [clojure.string :refer [split-lines split join]]))

(defn- split-line [line]
  (split line #"\s+"))

(defn- parse-numbers [xs]
  (mapv #(Integer/parseInt %) xs))

(defn build-dataset
  ([] (build-dataset "resources/day-6-input.txt"))
  ([filepath]
   (-> filepath
       slurp
       split-line
       parse-numbers)))

(defn select-bank [banks]
  (let [highest-value (apply max banks)]
    (first (keep-indexed #(if (= highest-value %2) %1) banks))))

(defn redistribute-blocks [banks blocks index]
  (if (zero? blocks)
    banks
    (if (= index (count banks))
      (recur banks blocks 0)
      (recur (assoc banks index (inc (banks index)))
             (dec blocks)
             (inc index)))))

(defn do-cycle [banks]
  (let [index (select-bank banks)
        blocks (banks index)]
    (redistribute-blocks (assoc banks index 0) blocks (inc index))))

(defn run-cycles-1 [cycles banks history]
  (let [result (do-cycle banks)]
    (if (contains? history result)
      cycles
      (recur (inc cycles) result (conj history result)))))

(defn run-cycles-2 [cycles banks history]
  (let [result (do-cycle banks)]
    (if (contains? history result)
      (- cycles (history result))
      (recur (inc cycles) result (assoc history result cycles)))))

(defn solve-1 [banks]
  (run-cycles-1 1 banks #{}))

(defn solve-2 [banks]
  (run-cycles-2 1 banks {}))
