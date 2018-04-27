package com.wr.riddles.hackerrank.week31;

import java.util.Scanner;

/**
 * See <a href="https://www.hackerrank.com/contests/w31/challenges/zero-one-game">https://www.hackerrank.com/contests/w31/challenges/zero-one-game</a>
 */
public class ZeroOneGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = in.nextInt();
            }
            System.out.println(winner(sequence));
        }
    }

    private static String winner(int[] seq) {
        int n = seq.length;
        int zeroCount = 0, total = 0;
        for (int i = 0; i < n; i++) {
            if (seq[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0 && i < n - 1 && seq[i + 1] == 0) {
                    zeroCount++;
                } else {
                    total += zeroCount > 2 ? zeroCount : 0;
                    zeroCount = 0;
                }
            }
        }
        total += zeroCount > 2 ? zeroCount : 0;
        return total % 2 == 0 ? "Bob" : "Alice";
    }
}
