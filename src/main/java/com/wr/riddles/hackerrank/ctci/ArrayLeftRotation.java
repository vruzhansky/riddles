package com.wr.riddles.hackerrank.ctci;

import java.util.Scanner;

public class ArrayLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt() % n;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = (i + n - k) % n;
            a[pos] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
