(ns advent-of-code.day-3)

(defn find-corners [ring]
  (mapv (partial * ring) [0 2 4 6]))

(defn find-closest-corner [corners offset]
  (first (sort (map #(Math/abs (- % offset)) corners))))

(defn calculate-steps [ring offset]
  (let [distance-from-corner (find-closest-corner (find-corners ring) offset)]
    (+ ring (- ring distance-from-corner))))

(defn find-ring-and-offset [ring n]
  (let [ring-size (* 8 ring)
        remainder (- n ring-size)]
    (if-not (pos? remainder)
      [ring (Math/abs remainder)]
      (recur (inc ring) remainder))))

(defn solve-1 [input]
  (if (= input 1)
    0
    (apply calculate-steps (find-ring-and-offset 1 (dec input)))))

#_ (find-ring-and-offset 1 11)
;; lookup for 12 => [2 13]

#_ (find-ring-and-offset 1 30)
;; lookup for 31 => [3 18]

#_ (find-ring-and-offset 1 48)
;; lookup for 49 => [3 0]

#_ (find-ring-and-offset 1 325489)
;; lookup for 325490 => [285 551] 


#_ (calculate-steps 2 -13)
#_ (calculate-steps 9 58)
#_ (calculate-steps 285 552)


