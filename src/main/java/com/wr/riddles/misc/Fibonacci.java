package com.wr.riddles.misc;

import java.util.ArrayList;
import java.util.List;

class Fibonacci {

    static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static List<Integer> memo = new ArrayList<>();

    static {
        memo.add(0);
        memo.add(1);
    }

    static int fibonacciMemo(int n) {
        if (n < memo.size()) {
            return memo.get(n);
        } else {
            int calculated = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
            memo.add(calculated);
            return calculated;
        }
    }
}
