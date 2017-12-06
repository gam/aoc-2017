(ns advent-of-code.day-3-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-3 :refer :all]))

(deftest day-3-first-challenge
  (are [input expected] (= (solve-1 input) expected)
    1    0
    12   3
    23   2
    1024 31))
  
#_(comment
65  64  63  62  61  60  59  58  57
66  37  36  35  34  33  32  31  56
67  38  17  16  15  14  13  30  55
68  39  18   5   4   3  12  29  54
69  40  19   6   1   2  11  28  53
70  41  20   7   8   9  10  27  52
71  42  21  22  23  24  25  26  51
72  43  44  45  46  47  48  49  50
73  74  75  76  77  78  79  80  81)


;; 24 -> (< n 4)
;; 16 -> (< n 3)
;; 8  -> (< n 2) ring=1

;; Ring-størrelse for ring 285: 2280
;; avstand: 
;; 326041 (max i ringen vi er på)
;; 323761 (ringen under den vi er på)
