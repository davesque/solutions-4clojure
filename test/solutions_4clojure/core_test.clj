(ns solutions-4clojure.core-test
  (:require [clojure.test :refer :all]
            [solutions-4clojure.core :refer :all]))

(deftest my-interleave-test
  (testing "It interleaves lists."
    (is (= (my-interleave [1 2 3] [:a :b :c]) [1 :a 2 :b 3 :c])))
  (testing "It correctly handles lists of differing length."
    (is (= (my-interleave [1 2] [:a :b :c]) [1 :a 2 :b])))
  (testing "It correctly handles empty lists."
    (is (= (my-interleave [] [:a :b :c]) []))))
