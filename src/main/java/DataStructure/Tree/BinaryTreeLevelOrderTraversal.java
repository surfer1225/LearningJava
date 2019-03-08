package main.java.DataStructure.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 26/12/17.
 */

/*
Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> l = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        goDownTree(root, 0);
        return l;
    }

    private void goDownTree(TreeNode cur, int level) {
        if (cur==null) return;
        if (l.size()==level) {
            List<Integer> newL = new LinkedList<>();
            newL.add(cur.val);
            l.add(newL);
        }
        else {
            l.get(level).add(cur.val);
        }
        goDownTree(cur.left, level+1);
        goDownTree(cur.right, level+1);
    }

    Map<Integer, List<Integer>> m = new HashMap<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        goDown(root, 0);
        // bottom up
        for (int i=m.size()-1;i>=0;i--) {
            l.add(m.get(i));
        }
        return l;
    }

    private void goDown(TreeNode cur, int level) {
        if (cur==null) return;
        goDown(cur.left, level+1);
        goDown(cur.right, level+1);
        if (!m.containsKey(level)) {
            List<Integer> newL = new LinkedList<>();
            newL.add(cur.val);
            m.put(level, newL);
        }
        else {
            m.get(level).add(cur.val);
        }
    }
}
