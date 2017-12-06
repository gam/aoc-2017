(ns advent-of-code.day-2-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-2 :refer :all]))

(def ^:private test-input-1
  "5 1 9 5
7 5 3
2 4 6 8")

(def ^:private test-input-2
  "5 9 2 8
9 4 7 3
3 8 6 5")

(deftest day-2-first-challenge
    (is (= (solve-1 test-input-1) 18)))  
  
(deftest day-2-second-challenge
  (is (= (solve-2
          test-input-2) 9)))  
