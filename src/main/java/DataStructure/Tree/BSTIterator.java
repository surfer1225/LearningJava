package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 4/5/18.
 */

/*
Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
where h is the height of the tree.
 */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BSTIterator {
    public BSTIterator(TreeNode root) {

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return 1;
    }
}
