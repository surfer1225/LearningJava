package main.java.leetcode.RevisionQns;

/*
124. Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes
from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.
Example 1:
Input: [1,2,3]
       1
      / \
     2   3
Output: 6
Example 2:
Input: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
Output: 42
 */
public class BTreeMaxPathSum {
    /*
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
     */

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res = maxPathSumHelper(root);
        return Math.max(res, max);
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        // check the value for each node
        max = Math.max(node.val, max);
        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);
        // check the value for each branch
        max = Math.max(max, Math.max(left, right));
        // check the case for cross bridge
        if (left>=0 && right>=0) max = Math.max(max, node.val+left+right);
        // return the max branch value
        return Math.max(node.val, Math.max(node.val + (left==Integer.MIN_VALUE?0:left),
                node.val + (right==Integer.MIN_VALUE?0:right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BTreeMaxPathSum bt = new BTreeMaxPathSum();
        System.out.println(bt.maxPathSum(root));
    }
}
