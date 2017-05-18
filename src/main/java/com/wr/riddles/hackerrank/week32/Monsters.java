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
        int i = 0;
        while (i < n) {
            h[i] -= hit;
            if (h[i] < 1) {
                max++;
                i++;
            }
            t--;
            if (t == 0) break;
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
