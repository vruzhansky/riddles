package com.wr.riddles.misc;

import com.wr.riddles.hackerrank.ctci.Fibonacci;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class FibonacciTest {

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(9, 34),
                Arguments.of(10, 55),
                Arguments.of(19, 4181)
        );
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void testFibonacci(int input, int expected) {
        int actual = Fibonacci.fibonacci(input);
        assertThat(actual, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void testFibonacciMemorized(int input, int expected) {
        int actual = Fibonacci.fibonacciMemo(input);
        assertThat(actual, equalTo(expected));
    }
}