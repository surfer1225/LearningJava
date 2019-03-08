package main.java.leetcode.RevisionQns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan on 14/1/18.
 */

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());
        for (int i=0;i<nums.length;i++) {
            for (List<Integer> l:new LinkedList<>(lists)) {
                List<Integer> temp = new LinkedList<>(l);
                temp.add(nums[i]);
                lists.add(new LinkedList<>(temp));
            }
        }
        return lists;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }

    /* backtrack solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
     */

    public static void main(String[] args) {
        SubSets s = new SubSets();
        List<List<Integer>> lists = s.subsets(new int[]{1, 2, 3});
        for (List<Integer> l:lists) {
            for (Integer i:l) {
                System.out.print("" + i + " ");
            }
            System.out.println();
        }
    }
}
