package main.java.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 3/2/18.
 */
/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 */
public class BottomLeft {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        bottomLeftHelper(root, l, 0);
        System.out.println(l.size());
        return l.get(l.size() - 1);
    }

    private void bottomLeftHelper(TreeNode tn, List<Integer> l, int lvl) {
        if (tn == null) return;
        if (l.size() <= lvl) {
            l.add(tn.val);
        }
        bottomLeftHelper(tn.left, l, lvl + 1);
        bottomLeftHelper(tn.right, l, lvl + 1);
    }
}
