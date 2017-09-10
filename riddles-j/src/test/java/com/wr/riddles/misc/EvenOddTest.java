package com.wr.riddles.misc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EvenOddTest {

    @DataProvider(name = "numbers")
    public static Object[][] numbers() {
        return new Object[][]{
                {new int[]{4, 5, 6, 7}, new int[]{4, 6, 5, 7}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{8, 2, 6, 4, 5, 3, 7, 1, 9}},
                {new int[]{4, 5, 6, 7}, new int[]{4, 6, 5, 7}},
        };
    }

    @Test(dataProvider = "numbers")
    public void testEvensFirst(int[] input, int[] expected) throws Exception {
        int[] actual = EvenOdd.evensFirst(input);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "numbers")
    public void testEvensFirst2(int[] input, int[] expected) throws Exception {
        int[] actual = EvenOdd.evensFirst2(input);
        Assert.assertEquals(actual, expected);
    }
}