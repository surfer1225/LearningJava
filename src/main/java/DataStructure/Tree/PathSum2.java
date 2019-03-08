package main.java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 25/12/17.
 */

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSum2 {

    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        addPathSum(root, sum, 0, new LinkedList<>());
        return res;
    }

    private void addPathSum(TreeNode node, int sum, int curSum, List<Integer> tempList) {
        if (node==null) return;
        curSum+=node.val;
        tempList.add(node.val);
        if (node.left==null&&node.right==null&&curSum==sum) {
            res.add(new LinkedList<>(tempList));
            return;
        }
        addPathSum(node.left, sum, curSum, new LinkedList<>(tempList));
        addPathSum(node.right, sum, curSum, new LinkedList<>(tempList));
    }
}
