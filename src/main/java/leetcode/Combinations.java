package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 14/2/18.
 */

/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

public class Combinations {
    List<List<Integer>> l = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1, new ArrayList<>());
        return l;
    }

    private void combineHelper(int n, int k, int start, List<Integer> tempL) {
        if (tempL.size()==k) {
            l.add(new LinkedList<>(tempL));
            return;
        }
        else {
            for (int i=start;i<=n;i++) {
                tempL.add(i);
                combineHelper(n, k, i+1, tempL);
                tempL.remove(tempL.size()-1);
            }
        }
    }
}
