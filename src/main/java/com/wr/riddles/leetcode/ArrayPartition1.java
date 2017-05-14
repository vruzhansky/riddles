package com.wr.riddles.leetcode;

import java.util.Arrays;

/**
 * See <a href="https://leetcode.com/problems/array-partition-i/#/description">https://leetcode.com/problems/array-partition-i/#/description</a>
 */
public class ArrayPartition1 {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2, 3, 4, 6, 7, 9, 11, 15, 1}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
