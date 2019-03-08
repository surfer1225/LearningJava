package main.java.DataStructure.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ryan on 10/1/18.
 */

/*
You are given n pairs of numbers.
In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

test cases to consider:
[[-10,-8],[8,9],[-5,0],[6,10],[-6,-4],[1,7],[9,10],[-4,7]]
 */
public class MaxPairChain {
    public int findLongestChain(int[][] pairs) {
        int l = pairs.length;
        if (l<=1) return l;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        //for (int i=0;i<l;i++) System.out.println(pairs[i][0]);
        int[] res = new int[l];
        res[0] = 1;
        int max = 0;
        for (int i=1;i<l;i++) {
            boolean found=false;
            for (int j=i-1;j>=0;j--) {
                if (pairs[i][0]>pairs[j][1]) {
                    found = true;
                    res[i]=res[j]+1>res[i]?res[j]+1:res[i];
                }
            }
            if (!found) res[i]=1;
            max = res[i]>max?res[i]:max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPairChain m = new MaxPairChain();
        System.out.println(m.findLongestChain(new int[][]{{-10, -8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}}));
    }
}
