package com.wr.riddles.hackerrank.algos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubSet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }

        System.out.println(maxSubset(set, k));
    }

    public static int maxSubset(Set<Integer> set, int k) {
        int[] rem = new int[k];
        for (int i : set) {
            rem[i % k]++;
        }
        int count = 0;
        for (int i = 0, j = k; i <= j; i++, j--) {
            if (i == 0) {
                count += rem[i] > 0 ? 1 : 0;
            } else if (i == k / 2 && k % 2 == 0) {
                count += rem[i] > 0 ? 1 : 0;
            } else {
                count += rem[i] > rem[j] ? rem[i] : rem[j];
            }
        }
        return count;
    }
}
