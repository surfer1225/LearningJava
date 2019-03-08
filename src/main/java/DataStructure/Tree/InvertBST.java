package main.java.DataStructure.Tree;

import apple.laf.JRSUIUtils;

/**
 * Created by Ryan on 7/1/18.
 */

/*

Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class InvertBST {
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
