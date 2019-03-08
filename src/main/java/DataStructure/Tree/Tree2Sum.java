package main.java.DataStructure.Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ryan on 12/1/18.
 */

/*
Given a Binary Search Tree and a target number,
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class Tree2Sum {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return findTargetHelper(s, root, k);
    }

    private boolean findTargetHelper(Set<Integer> s, TreeNode node, int k) {
        if (node==null) return false;
        if (s.contains(k-node.val)) return true;
        s.add(node.val);
        return findTargetHelper(s, node.right, k) || findTargetHelper(s, node.left, k);
    }
}
