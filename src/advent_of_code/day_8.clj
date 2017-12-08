(ns advent-of-code.day-8
  (require [clojure.string :refer [split-lines split]]))

(def ^:private puzzle-input "resources/day-8-input.txt")

(def max-value (atom 0))

(def conditions {"==" =
                 "!=" not=
                 "<"  <
                 ">"  >
                 "<=" <=
                 ">=" >=})

(def operations {"inc" +
                 "dec" -})



(defn build-dataset []
  (->> puzzle-input
       slurp
       split-lines
       (map split-line)))

(defn split-line [line]
  (split line #"\s+"))

(defn decode-instruction [[update-register
                           update-operation
                           update-parameter
                           _
                           condition-register
                           condition-operator
                           condition-value] registers]
  (let [comparator (conditions condition-operator)
        operation (operations update-operation)
        actual-value (get registers condition-register 0)]
    [[comparator actual-value (Integer/parseInt condition-value)]
     [operation update-register (Integer/parseInt update-parameter)]]))

(defn check-condition [[comparator register-value condition-value]]
  (comparator register-value condition-value))

(defn perform-update [[operation register delta] registers]
  (let [current-value (get registers register 0)
        new-value (operation current-value delta)]
    (when (> new-value @max-value)
        (reset! max-value new-value))
    (assoc registers register new-value)))

(defn calculate [[condition update] registers]
  (if (check-condition condition)
    (perform-update update registers)
    registers))

(defn execute-instructions [registers instructions]
  (if (empty? instructions)
    registers
    (recur (calculate (decode-instruction (first instructions) registers) registers)
           (rest instructions))))

(defn solve-1 [dataset]
  (apply max (vals (execute-instructions {} dataset))))

(defn solve-2 [dataset]
  (execute-instructions {} dataset)
  @max-value)

#_ (solve-1 (build-dataset))
#_ (solve-2 (build-dataset))

