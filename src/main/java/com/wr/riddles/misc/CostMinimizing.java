package com.wr.riddles.misc;

/**
 * A man has to travel for given number of days by bus. He can buy either:
 * <p>
 * 1 day ticket for 2$ (valid for 1 day)
 * 7 days ticket for 7$ (valid for 7 consecutive days)
 * 30 days ticket for 25$ (valid for 30 consecutive days)
 * We are given an array, whose elements are the day numbers on which he travels.
 * <p>
 * For example, if the given array is {1,3,5,8,9,10}, then he travels on these 6 days.
 * Now we have to minimize the cost of his travel
 */
public class CostMinimizing {
    private final int[] days;

    public CostMinimizing(int[] days) {
        this.days = days;
    }

    public int cost() {
        int[] costs = new int[days.length];

        for (int i = days.length - 1; i >= 0; i--) {
            if (i == days.length - 1) {
                costs[i] = 2;
            } else {
                int temp = costs[i + 1] + 2;
                if (temp > 25) {
                    costs[i] = Math.min(temp, 25 + costForDay(days[i] + 29));
                } else if (temp > 7) {
                    costs[i] = Math.min(temp, 7 + costForDay(days[i] + 6));
                } else {
                    costs[i] = temp;
                }
            }
        }
        return costs[0];
    }

    private int costForDay(int day) {
        int cost = 0, i = days.length - 1;
        while (day < days[i]) {
            i--;
            cost = days[i];
        }
        return cost;
    }
}