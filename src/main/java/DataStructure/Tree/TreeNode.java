package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 25/12/17.
 */

// used by all programs in the package
class TreeNode {
    TreeNode left, right;
    int val;

    //public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
