package com.wr.riddles.misc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CostMinimizingTest {

    @DataProvider(name = "days")
    public static Object[][] numbers() {
        return new Object[][]{
                {new CostMinimizing(new int[]{1, 3, 5, 8, 9, 10}), 11},
                {new CostMinimizing(new int[]{1, 2, 3, 4}), 7},
                {new CostMinimizing(new int[]{1, 3, 10, 17, 24, 31}), 12},
                {new CostMinimizing(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 17, 24, 31}), 17},
        };
    }

    @Test(dataProvider = "days")
    public void testCost(CostMinimizing costMinimizing, int expected) throws Exception {
        assertThat(costMinimizing.cost(), equalTo(expected));
    }
}