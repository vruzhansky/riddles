package com.wr.riddles.hackerrank.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node names = new Node();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            if ("add".equals(op)) {
                addContact(contact, names);
            }

            if ("find".equals(op)) {
                Node match = findMatch(contact, names);
                System.out.println(match != null ? match.matches : 0);
            }
        }
    }

    static class Node {
        Map<Character, Node> nextChars = new HashMap<>();
        boolean isWord;
        int matches;
    }

    static void addContact(String contact, Node node) {
        if (contact.length() == 0) {
            node.isWord = true;
            return;
        }
        Node nextNode = node.nextChars.computeIfAbsent(contact.charAt(0), k -> new Node());
        nextNode.matches++;
        addContact(contact.substring(1), nextNode);
    }

    static Node findMatch(String contact, Node node) {
        if (contact.length() == 0) {
            return node;
        }
        Node nextNode = node.nextChars.get(contact.charAt(0));
        if (nextNode != null) {
            return findMatch(contact.substring(1), nextNode);
        } else {
            return null;
        }
    }
}
