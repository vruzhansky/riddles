package com.wr.riddles.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {
    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char i : first.toCharArray()) {
            chars.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        for (char i : second.toCharArray()) {
            chars.compute(i, (k, v) -> v == null ? -1 : v - 1);
        }
        return chars.entrySet().stream().mapToInt(e -> Math.abs(e.getValue())).sum();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
