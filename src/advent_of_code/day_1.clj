(ns advent-of-code.day-1)

(defn sum-if-equal
  ([xs]
   (sum-if-equal 0 (last xs) xs))
  ([acc x xs]
   (if (empty? xs)
     acc
     (if (= x (first xs))
       (recur (+ acc x) (first xs) (rest xs))
       (recur acc (first xs) (rest xs))))))

(defn solve-1 [input]
  (let [numbers (map #(Character/digit % 10) (str input))]
    (sum-if-equal numbers)))

(defn rotate-list [xs]
  (let [n (/ (count xs) 2)]
    (concat (take-last n xs) (drop-last n xs))))

(defn solve-2 [input]
  (let [numbers (map #(Character/digit % 10) (str input))]
    (apply + (map #(if (= %1 %2) %1 0) numbers (rotate-list numbers)))))


