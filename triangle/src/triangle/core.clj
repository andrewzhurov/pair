(ns triangle.core
  (:require [clojure.test :refer [deftest testing is run-tests]]
   ))

(defn add-zeros [line]
  (concat [0] line [0]))

(defn new-line [line]
  (let [with-zeros (add-zeros line)
        parted (partition 2 1 with-zeros)
        summed (map #(apply + %) parted)]
    summed))

#_(defn get-line
  ([number] (get-line '(1) number))
  ([line number]
    (if (= number 0)
        line
        (recur (new-line line) (dec number)))))

(defn get-line [number]
  (if (= number 0)
      '(1)
      (new-line (get-line (dec number)))))
(deftest add-zeros-test
  (testing "all"
    (is (= (add-zeros '(1)) '(0 1 0)))
    (is (= (add-zeros '(1 4 6 4 1)) '(0 1 4 6 4 1 0)))
  ))

(deftest new-line-test
  (testing "all"
    (is (= (new-line [1]) '(1 1)))
    (is (= (new-line [1 3 3 1]) '(1 4 6 4 1)))
))

(deftest get-line-test
  (testing "all"
    (is (= (get-line 0) '(1)))
    (is (= (get-line 1) '(1 1)))
    (is (= (get-line 4) '(1 4 6 4 1)))
  )
)

(run-tests)
