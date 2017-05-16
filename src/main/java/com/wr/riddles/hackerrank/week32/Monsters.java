package com.wr.riddles.hackerrank.week32;

import java.util.Arrays;
import java.util.Scanner;

/**
 * See <a href="https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters">https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters</a>
 */
public class Monsters {

    static int getMaxMonsters(int n, int hit, int t, int[] h) {
        Arrays.sort(h);
        int max = 0;
        for (int i = 0; i < t; i++) {
            int j = 0;
            while (h[j] < 1 || j > n - 1) {
                j++;
            }
            // all monsters are dead
            if (j == n) break;
            h[j] -= hit;
            if (h[j] < 1) max++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int hit = in.nextInt();
        int t = in.nextInt();
        int[] h = new int[n];
        for (int h_i = 0; h_i < n; h_i++) {
            h[h_i] = in.nextInt();
        }
        int result = getMaxMonsters(n, hit, t, h);
        System.out.println(result);
    }
}
