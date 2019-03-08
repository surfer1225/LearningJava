package main.java.leetcode;

import java.util.List;

/**
 * Created by Ryan on 25/12/17.
 */

/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.
 */
public class MinTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minTotalHelper(triangle, 0, 0, 0);
    }

    private int minTotalHelper(List<List<Integer>> triangle, int layer, int index, int curSum) {
        curSum+=triangle.get(layer).get(index);
        if (triangle.size()-1==layer) return curSum;
        int left=minTotalHelper(triangle,layer+1, index, curSum);
        int right=minTotalHelper(triangle,layer+1, index+1, curSum);
        return Math.min(left, right);
    }

    // best way is thru dp, from bottom up, add layer by layer with the smaller value
}
