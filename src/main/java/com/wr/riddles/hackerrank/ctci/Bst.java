package com.wr.riddles.hackerrank.ctci;

public class Bst {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node node, int lowConstraint, int topConstraint) {
        return node == null ||
                lowConstraint < node.data && node.data < topConstraint
                        && checkBST(node.left, lowConstraint, node.data)
                        && checkBST(node.right, node.data, topConstraint);
    }
}
