package com.wr.riddles.hackerrank.ctci;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }
        Map<String, Integer> words = Stream.of(magazine)
                .collect(Collectors.toMap(w -> w, w -> 1, (oldValue, newValue) -> oldValue + newValue));

        for (String word : ransom) {
            Integer count = words.get(word);
            if (count == null || count < 1) {
                System.out.println("No");
                return;
            } else {
                words.computeIfPresent(word, (w, c) -> c - 1);
            }
        }
        System.out.println("Yes");
    }
}
