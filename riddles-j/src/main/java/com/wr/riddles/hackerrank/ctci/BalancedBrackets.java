package com.wr.riddles.hackerrank.ctci;

import java.util.*;

public class BalancedBrackets {
    static Map<Character, Character> matches = new HashMap<>();

    static {
        matches.put('(', ')');
        matches.put('[', ']');
        matches.put('{', '}');
    }

    public static boolean isBalanced(String expression) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : expression.toCharArray()) {
            if (matches.keySet().contains(c)) {
                stack.push(c);
            } else {
                try {
                    if (matches.get(stack.pop()) != c) {
                        return false;
                    }
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
