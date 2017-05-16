package com.wr.riddles.hackerrank.algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * See <a href="https://www.hackerrank.com/challenges/bear-and-steady-gene">https://www.hackerrank.com/challenges/bear-and-steady-gene</a>
 */
public class SteadyGenes {
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String dnaS = in.next();

        Map<Character, Integer> genes = new HashMap<>();
        genes.put('A', 0);
        genes.put('C', 0);
        genes.put('T', 0);
        genes.put('G', 0);

        char[] dna = dnaS.toCharArray();
        for (char c : dna) {
            genes.computeIfPresent(c, (k, v) -> v + 1);
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while (right < n - 1) {
            char rightChar = dna[right++];
            genes.computeIfPresent(rightChar, (k, v) -> v - 1);
            while (isSteady(genes)) {
                min = Math.min(min, right - left);
                char leftChar = dna[left++];
                genes.computeIfPresent(leftChar, (k, v) -> v + 1);
            }
        }

        System.out.println(min);
    }

    static boolean isSteady(Map<Character, Integer> missingGenes) {
        for (int c : missingGenes.values()) {
            if (c > n / 4) return false;
        }
        return true;
    }
}
