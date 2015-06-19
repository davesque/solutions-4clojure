(ns solutions-4clojure.core-test
  (:require [clojure.test :refer :all]
            [solutions-4clojure.core :refer :all]))

(deftest my-interleave-test
  (testing "It interleaves lists."
    (is (= (my-interleave [1 2 3] [:a :b :c]) [1 :a 2 :b 3 :c])))
  (testing "It correctly handles lists of differing length."
    (is (= (my-interleave [1 2] [:a :b :c]) [1 :a 2 :b])))
  (testing "It correctly handles empty lists."
    (is (= (my-interleave [] [:a :b :c]) [])))
  (testing "It handles more than two lists."
    (is (= (my-interleave [1 2 3] [:a :b :c] '(a b c)) '[1 :a a 2 :b b 3 :c c]))))

(deftest my-interpose-test
  (testing "It interposes a list."
    (is (= (my-interpose 0 [:a :b :c]) [:a 0 :b 0 :c])))
  (testing "It correctly handles lists with length one."
    (is (= (my-interpose 0 [:a]) [:a])))
  (testing "It correctly handles empty lists."
    (is (= (my-interpose 0 []) []))))

(deftest drop-every-nth-test
  (testing "Drops every nth item in a list."
    (is (= (drop-every-nth [:a :b :c] 2) [:a :c])))
  (testing "Correctly handles empty lists."
    (is (= (drop-every-nth [] 2) [])))
  (testing "Correctly handles uneven lengths."
    (is (= (drop-every-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))))

(deftest get-the-caps-test
  (testing "It should filter capital letters in a string."
    (is (= (get-the-caps "arstARSTarstARST") "ARSTARST")))
  (testing "It should work with empty strings."
    (is (= (get-the-caps "") "")))
  (testing "It should work when the string has no caps."
    (is (= (get-the-caps "arst") ""))))

(deftest compress-a-sequence-test
  (testing "It should compress a sequence."
    (is (= (apply str (compress-a-sequence "aaaabbbbbccccc")) "abc")))
  (testing "It should work for any list of equatable values."
    (is (= (compress-a-sequence [[1 2] [3 4] [1 2] [1 2]]) [[1 2] [3 4] [1 2]])))
  (testing "It should work for empty lists."
    (is (= (compress-a-sequence []) []))))

(deftest pack-a-sequence-test
  (testing "It should pack a sequence."
    (is (= (map (partial apply str) (pack-a-sequence "aaaabbbbbccccc")) ["aaaa" "bbbbb" "ccccc"])))
  (testing "It should work for any list of equatable values."
    (is (= (pack-a-sequence [[1 2] [3 4] [1 2] [1 2]]) [[[1 2]] [[3 4]] [[1 2] [1 2]]])))
  (testing "It should work for empty lists."
    (is (= (pack-a-sequence []) []))))

(deftest my-range-test
  (testing "It should generate a range which is exclusive on the end."
    (is (= (my-range 1 10) '(1 2 3 4 5 6 7 8 9))))
  (testing "It should work for negative starting numbers."
        (is (= (my-range -1 10) '(-1 0 1 2 3 4 5 6 7 8 9)))))
