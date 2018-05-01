package com.wr.riddles.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class CostMinimizingTest {

    private static Stream<Arguments> costs() {
        return Stream.of(
                Arguments.of(new CostMinimizing(new int[]{1, 3, 5, 8, 9, 10}), 11),
                Arguments.of(new CostMinimizing(new int[]{1, 2, 3, 4}), 7),
                Arguments.of(new CostMinimizing(new int[]{1, 3, 10, 17, 24, 31}), 12),
                Arguments.of(new CostMinimizing(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 17, 24, 31}), 17)
        );
    }

    @ParameterizedTest
    @MethodSource("costs")
    void testCost(CostMinimizing costMinimizing, int expected) {
        assertThat(costMinimizing.cost(), equalTo(expected));
    }
}