(ns solutions-4clojure.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn my-last [l]
  (let [dc (comp dec count)]
    (nth l (dc l))))

(defn my-nth [l n]
  (last (take (inc n) l)))

(defn my-count [l]
  (reduce (fn [a i] (inc a)) 0 l))

(defn my-reverse [l]
  (into () l))

(def my-sum (partial reduce +))
(def my-odd (partial filter odd?))

(defn fibs [x]
  (loop [xs [1 1] i (- x 2)]
    (if (> i 0)
      (recur
        (conj xs (reduce + (take-last 2 xs)))
        (dec i))
      xs)))

(defn loop-test []
  (loop [x 1 y 2]
    (when (> x -20)
      (println (str x ", " y))
      (recur (dec x) (inc y)))))

(defn palindrome? [l]
  (= (vec l) (reverse l)))

(defn my-max [& args]
  (reduce #(if (> %1 %2) %1 %2) args))

(defn my-interleave [& args]
  (loop [l []
         args' args]
    (if (some empty? args')
      l
      (recur
        (into l (map first args'))
        (map rest args')))))

(defn my-interpose [x xs]
  (if (empty? xs)
    xs
    (loop [l [] xs' xs]
      (if (= (count xs') 1)
        (into l xs')
        (recur
          (into l [(first xs') x])
          (rest xs'))))))
