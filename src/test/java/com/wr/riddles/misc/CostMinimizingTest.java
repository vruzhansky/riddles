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
        };
    }

    @Test(dataProvider = "days")
    public void testCost(CostMinimizing costMinimizing, int expected) throws Exception {
        assertThat(costMinimizing.cost(), equalTo(expected));
    }
}