package com.wr.riddles.misc;

/**
 * Singly linked list reversal
 *
 */
class Linked {
    static class Node {
        final String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    static Node reverse(Node head) {
        Node prev = null, cur = head, next = head;

        while(next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
