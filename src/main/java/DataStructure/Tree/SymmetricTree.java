package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 26/12/17.
 */

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameTree(root.right, root.left);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p!=null&&q==null) return false;
        if (p==null&&q!=null) return false;
        if (p.val!=q.val) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
