package com.wr.riddles.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * See <a href="https://leetcode.com/problems/two-sum/#/description">https://leetcode.com/problems/two-sum/#/description</a>
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = m.getOrDefault(target - nums[i], -1);
            if (idx != -1) return new int[]{idx, i};
            m.put(nums[i], i);
        }
        return new int[0];
    }

}