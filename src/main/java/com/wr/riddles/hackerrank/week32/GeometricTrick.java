package com.wr.riddles.hackerrank.week32;

import java.util.*;

public class GeometricTrick {

    static int geometricTrick(String s) {
        Set<Long> a = new HashSet<>();
        Set<Long> b = new HashSet<>();
        Set<Long> c = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a.add((long) i + 1);
            if (s.charAt(i) == 'c') c.add((long) i + 1);
            if (s.charAt(i) == 'b') b.add((long) (i + 1) * (i + 1));
        }
        int count = 0;
        for (long i : c) {
            for (long j : a) {
                if (b.contains(i * j)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = geometricTrick(s);
        System.out.println(result);
    }
}
