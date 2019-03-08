package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 25/12/17.
 */

/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum, 0);
    }

    private boolean hasPathSumHelper(TreeNode node, int sum, int curSum) {
        if (node==null) return false;
        curSum+=node.val;
        if (node.left==null&&node.right==null&&curSum==sum) return true;
        return hasPathSumHelper(node.left, sum, curSum) || hasPathSumHelper(node.right, sum, curSum);
    }
}
