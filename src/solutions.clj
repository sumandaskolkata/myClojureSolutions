(ns solutions)

1.
(= true true)

2.
(= (- 10 (* 2 3)) 4)

3.
(= "HELLO WORLD" (.toUpperCase "hello world"))

4.
(= (list :a :b :c) '(:a :b :c))

5.
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

6.
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

7.
(= (vector 1 2 3 4) (conj [1 2 3] 4))
(= (vector 1 2 3 4) (conj [1 2] 3 4))

8.
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

9.
(= #{1 2 3 4} (conj #{1 4 3} 2))

10.
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

11.
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

12.
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

13.
(= (list 20 30 40) (rest [10 20 30 40]))

14.
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

15.
(= ((fn [x] (* 2 x)) 2) 4)
(= ((fn [x] (* 2 x)) 3) 6)
(= ((fn [x] (* 2 x)) 11) 22)
(= ((fn [x] (* 2 x)) 7) 14)

16.
(= ((fn [name] (str "Hello, " name "!")) "Dave") "Hello, Dave!")
(= ((fn [name] (str "Hello, " name "!")) "Jenn") "Hello, Jenn!")
(= ((fn [name] (str "Hello, " name "!")) "Rhea") "Hello, Rhea!")

17.
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

18.
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

19.
(= ((fn [x] (first (reverse x))) [1 2 3 4 5]) 5)
(= ((fn [x] (first (reverse x))) '(5 4 3)) 3)
(= ((fn [x] (first (reverse x))) ["b" "c" "d"]) "d")

20.
(= ((fn [x] (first (rest (reverse x)))) (list 1 2 3 4 5)) 4)
(= ((fn [x] (first (rest (reverse x)))) ["a" "b" "c"]) "b")
(= ((fn [x] (first (rest (reverse x)))) [[1 2] [3 4]]) [1 2])

21.
(= ((fn [listof th] (get (vec listof) th)) '(4 5 6 7) 2) 6)
(= ((fn [listof th] (get (vec listof) th)) [:a :b :c] 0) :a)
(= ((fn [listof th] (get (vec listof) th)) [1 2 3 4] 1) 2)
(= ((fn [listof th] (get (vec listof) th)) '([1 2] [3 4] [5 6]) 2) [5 6])

22.
(= (#(inc (second (last (map list % (range))))) '(1 2 3 3 1)) 5)
(= (#(inc (second (last (map list % (range))))) "Hello World") 11)
(= (#(inc (second (last (map list % (range))))) [[1 2] [3 4] [5 6]]) 3)
(= (#(inc (second (last (map list % (range))))) '(13)) 1)
(= (#(inc (second (last (map list % (range))))) '(:a :b :c)) 3)











(fn [limit colle] ((reduce #(conj %1 (take limit (drop (* %2 limit) colle))) [] (range (quot (count colle) limit)))))



(fn myPartition [ limit coll]
    (if  (< (count coll) limit)
      '()
      (cons
        (first (split-at limit coll))
        (myPartition limit (last (split-at limit coll))))))


(fn [n coll]
    (map #(take-last n (take (* % n) coll)) (range 1 (inc (quot (count coll) n)))))


(fn [coll]
    (reduce  #(merge %1 %2)
             (map
               (fn [ele] (hash-map (key ele) (count (val ele))))
               (group-by identity coll))))

(fn [coll]
    (reduce-kv (fn [%1 %2 %3] (assoc %1 %2 (count %3))) {} (group-by identity coll)))



(fn [coll] (map #(key %1) (group-by identity coll)))

(fn [coll] (reduce #(if(apply distinct? (conj %1 %2)) (conj %1 %2) %1) [] coll))




