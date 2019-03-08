package main.java.DataStructure.Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        if (n==1) return Collections.singletonList(new TreeNode(1));

        List<TreeNode> result = new LinkedList<>();
        List<TreeNode> l = generateTrees(n-1); // result from n-1
        for (TreeNode tn:l) {
            TreeNode cur = new TreeNode(n);
            cur.left = copyTree(tn);
            result.add(cur); // current node as the root
            // add all cases when the new node is in the right
            result.addAll(addToRight(tn,new TreeNode(n)));
        }
        return result;
    }

    private List<TreeNode> addToRight(TreeNode root, TreeNode tn) {
        List<TreeNode> result = new LinkedList<>();

        TreeNode cur = root;

        while (cur!=null) {
            TreeNode temp = cur.right;
            cur.right = tn;
            tn.left = temp;
            result.add(copyTree(root));
            cur.right=temp;
            cur = cur.right;
        }

        return result;
    }

    private TreeNode copyTree(TreeNode tn) {
        if (tn==null) return null;
        TreeNode root = new TreeNode(tn.val);
        root.left = copyTree(tn.left);
        root.right = copyTree(tn.right);
        return root;
    }
}
