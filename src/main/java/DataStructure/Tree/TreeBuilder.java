package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 26/12/17.
 */

/*

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

 */
public class TreeBuilder {

    public TreeNode buildTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(-3);
//        root.right.right = new TreeNode(11);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right.right = new TreeNode(1);
        return root;
    }
}
