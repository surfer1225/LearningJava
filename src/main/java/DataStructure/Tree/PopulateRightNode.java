package main.java.DataStructure.Tree;

/**
 * Created by Ryan on 28/1/18.
 */

/*
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
}
public class PopulateRightNode {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        connectNodes(root.left, root.right);
    }

    public void connectNodes(TreeLinkNode node1, TreeLinkNode node2) {
        node1.next = node2;
        if(node1.left != null) {
            connectNodes(node1.right, node2.left);
            connectNodes(node1.left, node1.right);
            connectNodes(node2.left, node2.right);
        }
    }
}
