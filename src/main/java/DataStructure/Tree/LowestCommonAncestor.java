package main.java.DataStructure.Tree;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {

    // from leetcode
    class Solution1 {

        private TreeNode ans;

        public Solution1() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
    }

    boolean isSet = false;
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isCommonAncestor(root, p, q);
        return res;
    }

    private boolean isCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        isCommonAncestor(node.right, p, q);
        isCommonAncestor(node.left, p, q);

        if (isSet) return false; // res is already obtained

        boolean containsP = containsNode(node, p);
        boolean containsQ = containsNode(node, q);

        if (containsP && containsQ) {
            isSet = true;
            res = node;
        }
        return containsP && containsQ;
    }

    private boolean containsNode(TreeNode node, TreeNode child) {
        if (node == null || child == null) return false;

        if (node.val == child.val) return true;

        return containsNode(node.left, child) || containsNode(node.right, child);
    }
}
