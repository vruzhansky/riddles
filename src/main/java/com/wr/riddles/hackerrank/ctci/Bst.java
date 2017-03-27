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
        if (node == null) {
            return true;
        }
        boolean isBst = true;
        if (node.left != null) {
            isBst = checkConstraints(node.left.data, lowConstraint, topConstraint)
                    && node.data > node.left.data
                    && checkBST(node.left, lowConstraint, Math.min(node.data, topConstraint));
        }
        if (node.right != null) {
            isBst &= checkConstraints(node.right.data, lowConstraint, topConstraint)
                    && node.data < node.right.data
                    && checkBST(node.right, Math.max(node.data, lowConstraint), topConstraint);
        }
        return isBst;
    }

    boolean checkConstraints(int val, int low, int top) {
        return low < val && val < top;
    }
}
