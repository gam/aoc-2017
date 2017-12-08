(ns advent-of-code.day-8-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-8 :refer :all]))

(def test-dataset
  [["b" "inc" "5"   "if" "a" ">"  "1"]
   ["a" "inc" "1"   "if" "b" "<"  "5"]
   ["c" "dec" "-10" "if" "a" ">=" "1"]
   ["c" "inc" "-20" "if" "c" "==" "10"]])

(deftest day-6-first-challenge
  (is (= (solve-1 test-dataset) 1)))

(deftest day-6-second-challenge
  (is (= (solve-2 test-dataset) 10)))
