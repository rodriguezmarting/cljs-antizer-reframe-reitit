(ns myapp.app-test
  (:require [cljs.test :refer-macros [deftest is testing]]))

(deftest test-numbers
  (testing "This is a dummy description"
    (is (= 1 1))))
