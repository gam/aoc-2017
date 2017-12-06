(ns advent-of-code.day-5-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-5 :refer :all]))

(def ^:private puzzle-input [0 3 0 1 -3])

(deftest day-5-first-challenge
  (is (= (solve-1 puzzle-input) 5)))

(deftest day-5-second-challenge
  (is (= (solve-2 puzzle-input) 10)))
