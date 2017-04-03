package com.wr.riddles.hackerrank.ctci;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    static class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Set<Node> visited = new HashSet<>();
        Node node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return true;
            } else {
                visited.add(node);
            }
            node = node.next;
        }
        return false;
    }

}
