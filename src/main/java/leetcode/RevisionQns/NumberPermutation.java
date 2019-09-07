package main.java.leetcode.RevisionQns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 14/12/17.
 */

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Hint: use backtrack
 */
public class NumberPermutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteHelper(lists, new ArrayList<>(), nums);
        return lists;
    }

    private void permuteHelper(List<List<Integer>> lists, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        }
        else {
            for (int i=0;i<nums.length;i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permuteHelper(lists, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NumberPermutation np = new NumberPermutation();
        List<List<Integer>> ll = np.permute(new int[]{1,2,1});
        for (List<Integer> l:ll) {
            for (int i:l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
