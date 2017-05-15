package com.wr.riddles.hackerrank.week32;

import java.util.Scanner;

/**
 * See <a href="https://www.hackerrank.com/contests/w32/challenges/duplication">https://www.hackerrank.com/contests/w32/challenges/duplication</a>
 */
public class Duplication {
    public static final String s = s("0");

    static String duplication(int x) {
        return String.valueOf(s.charAt(x));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            String result = duplication(x);
            System.out.println(result);
        }
    }

    static String s(String s) {
        if (s.length() > 1000) return s;
        return s(s + negate(s));
    }

    static String negate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char a : s.toCharArray()) {
            sb.append(a == '0' ? '1' : '0');
        }
        return sb.toString();

    }
}
