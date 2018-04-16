package com.wr.riddles.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Logins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Node logins = new Node();
        for (int i = 0; i < n; i++) {
            String login = br.readLine();
            if (n == 1) {
                System.out.println(login);
                return;
            }
            Node match = add(login, logins);
            if (match == null) {
                System.out.println(login);
            } else {
                System.out.println(login + suggest(match.suggest, match));
            }
        }
    }

    static Node add(String login, Node node) {
        Node n = node;
        for (char c : login.toCharArray()) {
            n = n.nextChars.computeIfAbsent(c, k -> new Node());
        }
        if (n.isWord) {
            return n;
        } else {
            n.isWord = true;
            return null;
        }
    }

    static long suggest(int suffix, Node node) {
        int suff = suffix;
        Node existing;
        do {
            existing = add(Integer.toString(suff), node);
            if (existing != null) {
                node.suggest++;
                suff = node.suggest;
            }
        } while (existing != null);
        return suff;
    }

    static class Node {
        Map<Character, Node> nextChars = new HashMap<>();
        boolean isWord;
        int suggest;
    }

}
