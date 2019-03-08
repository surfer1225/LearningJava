package main.java.DataStructure.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 12/1/18.
 */

/*
Given the root of a tree, you are asked to find the most frequent subtree sum.
The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted
at that node (including the node itself). So what is the most frequent subtree sum value?
If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 */
public class MostFrequentSubTreeSum {
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> m = new HashMap<>();
        subTreeSum(m, root);
        List<Integer> l = new LinkedList<>();
        for (int i:m.keySet()) {
            if (m.get(i)==max) l.add(i);
        }
        return l.stream().mapToInt(i -> i).toArray();
    }

    private int subTreeSum(Map<Integer, Integer> m, TreeNode node) {
        if (node==null) return 0;
        int sum = subTreeSum(m, node.left) + subTreeSum(m, node.right) + node.val;
        if (m.containsKey(sum)) {
            int cnt = m.get(sum)+1;
            max = Math.max(cnt, max);
            m.put(sum, cnt);
        }
        else {
            m.put(sum, 1);
            max = Math.max(1, max);
        }
        return sum;
    }

    public static void main(String[] args) {
        MostFrequentSubTreeSum m = new MostFrequentSubTreeSum();
        TreeBuilder t = new TreeBuilder();
        for (int i:m.findFrequentTreeSum(t.buildTree())) System.out.println(i);
    }
}
