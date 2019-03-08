package main.java.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 26/12/17.
 */

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

/*
test case:
[5,4,8,11,null,13,4,7,2,null,null,5,1]
22
 */
public class PathSum3 {
    int total = 0;
    public int pathSum(TreeNode root, int sum) {
        for (Integer i:pathSumHelper(root, sum)) {
            if (i==sum) total++;
        }
        return total;
    }

    private List<Integer> pathSumHelper(TreeNode cur, int sum) {
        if (cur==null) return new ArrayList<>();

        List<Integer> branchPaths = pathSumHelper(cur.left, sum);
        branchPaths.addAll(pathSumHelper(cur.right, sum));

        for (int i=0;i<branchPaths.size();i++) {
            if (branchPaths.get(i)==sum) total++;
            branchPaths.set(i, branchPaths.get(i)+cur.val);
        }
        branchPaths.add(cur.val);

        return branchPaths;
    }

    /*
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
     */

    public static void main(String[] args) {
        PathSum3 p = new PathSum3();
        TreeBuilder b = new TreeBuilder();
        System.out.println(p.pathSum(b.buildTree(), 8));
    }
}
