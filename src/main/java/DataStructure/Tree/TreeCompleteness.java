package main.java.DataStructure.Tree;

/*
958
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last,
is completely filled, and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.



Example 1:

Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreeCompleteness {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean hasNull = false;

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();

            if (tmp.left == null) {
                hasNull = true;
            }
            else {
                if (hasNull) return false;
                q.add(tmp.left);
            }

            if (tmp.right==null) {
                if (!hasNull) hasNull = true;
            }
            else {
                if (hasNull) return false;
                q.add(tmp.right);
            }
        }
        return true;
    }

}
