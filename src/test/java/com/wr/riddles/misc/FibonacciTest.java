package com.wr.riddles.misc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FibonacciTest {

    @DataProvider(name = "numbers")
    public static Object[][] numbers() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55},
                {19, 4181},
        };
    }

    @Test(dataProvider = "numbers")
    public void testFibonacci(int input, int expected) throws Exception {
        int actual = Fibonacci.fibonacci(input);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "numbers")
    public void testFibonacciMemorized(int input, int expected) throws Exception {
        int actual = Fibonacci.fibonacciMemo(input);
        Assert.assertEquals(actual, expected);
    }
}