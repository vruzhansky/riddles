package com.wr.riddles.hackerrank.ctci;

import java.util.Scanner;

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int a0 = 0; a0 < p; a0++) {
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    static boolean isPrime(int n) {
        if (n < 2 || n != 2 && n % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int j = 3; j <= sqrt; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
