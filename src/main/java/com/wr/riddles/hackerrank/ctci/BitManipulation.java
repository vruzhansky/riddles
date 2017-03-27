package com.wr.riddles.hackerrank.ctci;

import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int val = 0;
        for (int i : a) {
            val ^=i;
        }
        System.out.println(val);
    }
}
