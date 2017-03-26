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
        Integer memorized = memo.get(n);
        if (memorized != null) {
            return memorized;
        } else {
            int calculated = fibonacci(n - 1) + fibonacci(n - 2);
            memo.add(calculated);
            return calculated;
        }
    }
}
