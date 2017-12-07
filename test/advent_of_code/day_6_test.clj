(ns advent-of-code.day-6-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-6 :refer :all]))

(def ^:private test-input [0 2 7 0])

(deftest day-6-first-challenge
  (is (= (solve-1 test-input) 5)))

(deftest day-6-second-challenge
  (is (= (solve-2 test-input) 4)))
