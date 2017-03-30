package com.wr.riddles.hackerrank.ctci;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            int[] ways = new int[n + 1];
            ways[0] = 1;
            ways[1] = 1;
            System.out.println(ways(n, ways));
        }
    }

    static int ways(int n, int[] ways) {
        if (n < 0) {
            return 0;
        }
        if (ways[n] != 0) {
            return ways[n];
        }
        ways[n] = ways(n - 1, ways) + ways(n - 2, ways) + ways(n - 3, ways);
        return ways[n];
    }
}
