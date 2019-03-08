package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 26/12/17.
 */

// find max depth of BST
public class MaxBSTDepth {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }
}
