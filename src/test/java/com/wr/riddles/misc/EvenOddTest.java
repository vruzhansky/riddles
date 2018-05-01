package com.wr.riddles.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EvenOddTest {

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7}, new int[]{4, 6, 5, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{8, 2, 6, 4, 5, 3, 7, 1, 9}),
                Arguments.of(new int[]{4, 5, 6, 7}, new int[]{4, 6, 5, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void testEvensFirst(int[] input, int[] expected) {
        int[] actual = EvenOdd.evensFirst(input);
        assertThat(actual, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void testEvensFirst2(int[] input, int[] expected) {
        int[] actual = EvenOdd.evensFirst2(input);
        assertThat(actual, equalTo(expected));
    }
}