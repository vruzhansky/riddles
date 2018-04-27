package com.wr.riddles.hackerrank.ctci;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
//        System.out.println(change(n, m, coins));
        System.out.println(changeDP(n, m, coins));
    }

    static int change(int n, int m, int[] coins) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (m <= 0 && n >= 1) {
            return 0;
        }
        return change(n, m - 1, coins) + change(n - coins[m - 1], m, coins);
    }

    static long changeDP(int n, int m, int[] coins) {
        long[] combos = new long[n + 1];
        combos[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                combos[j] += combos[j - coins[i]];
            }
        }

        System.out.println(Arrays.toString(combos));
        return combos[n];
    }
}
