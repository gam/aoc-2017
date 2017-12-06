(ns advent-of-code.day-1-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-1 :refer :all]))

(deftest day-1-first-challenge
  (are [input expected]
      (= (solve-1 input) expected)
    1122     3  
    1111     4
    1234     0
    91212129 9))

(deftest day-1-second-challenge
  (are [input expected]
      (= (solve-2 input) expected)
    1212     6
    1221     0
    123425   4
    123123   12
    12131415 4))
