package main.java.DataStructure.Tree;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length==0) return null;
        return buildTree(preorder,inorder,0,inorder.length-1,new int[]{0});
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int low, int high, int[] index) {
        // can put this in hashmap to speed up
        int i=low;
        while (inorder[i]!=preorder[index[0]]) i++;

        TreeNode node = new TreeNode(inorder[i]);
        index[0]++;

        if (low==i) node.left=null;
        else node.left=buildTree(preorder,inorder,low,i-1,index);

        if (high==i) node.right=null;
        else node.right=buildTree(preorder,inorder,i+1,high,index);

        return node;
    }
}
