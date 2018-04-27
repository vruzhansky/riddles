package com.wr.riddles.hackerrank.ctci;

import org.junit.Assert;
import org.junit.Test;

public class BstTest {
    @Test
    public void testCheckBST() throws Exception {
        Bst.Node root = new Bst.Node();
        root.data = 4;

        Bst.Node left = new Bst.Node();
        left.data = 2;
        Bst.Node right = new Bst.Node();
        right.data = 6;

        root.left = left;
        root.right = right;

        left = new Bst.Node();
        left.data = 1;
        right = new Bst.Node();
        right.data = 3;

        root.left.left = left;
        root.left.right = right;

        left = new Bst.Node();
        left.data = 5;
        right = new Bst.Node();
        right.data = 7;
        root.right.left = left;
        root.right.right = right;


        Assert.assertTrue(new Bst().checkBST(root));

    }

}