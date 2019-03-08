package main.java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 12/2/18.
 */

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        List<Integer> l = new LinkedList<>();
        l.add(root.val);
        return validBSTHelper(root.left, new LinkedList<>(), new LinkedList<>(l))
                && validBSTHelper(root.right, new LinkedList<>(l), new LinkedList<>()) ;
    }

    private boolean validBSTHelper(TreeNode tn, List<Integer> bigger, List<Integer> smaller) {
        if (tn==null) return true;
        for (int i:smaller) {
            System.out.println("smaller: " + i + ", val: " + tn.val);
            if (tn.val >= i) return false;
        }
        for (int i:bigger) {
            System.out.println("bigger: " + i + ", val: " + tn.val);
            if (tn.val <= i) return false;
        }
        List<Integer> b = new LinkedList<>(bigger);
        b.add(tn.val);
        List<Integer> s = new LinkedList<>(smaller);
        s.add(tn.val);
        return validBSTHelper(tn.right, new LinkedList<>(b), smaller)
                && validBSTHelper(tn.left, bigger, new LinkedList<>(s));
    }
}
