package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 26/12/17.
 */
public class BalancedBinaryTree {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depthCount(root);
        return isBalanced;
    }

    private int depthCount(TreeNode n) {
        if (!isBalanced) return 0;
        if (n==null) return 0;
        int left = depthCount(n.left);
        int right = depthCount(n.right);
        isBalanced = Math.abs(left-right)<=1 && isBalanced;
        System.out.println("left, right, balanced, val: " + left + ", " + right + ", " + isBalanced + ", " + n.val);
        return Math.max(left,right)+1;
    }
}
