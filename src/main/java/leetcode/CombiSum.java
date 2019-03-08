package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ryan on 17/12/17.
 */

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

 */
public class CombiSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    private void backTrack(List<List<Integer>> lists, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain<0) return;
        if (remain==0) {
            System.out.println("solution found: ");
            for (int i:tempList) {
                System.out.println("i: " + i);
            }
            // important: a new list instead of the existing one
            List<Integer> listToAdd = new ArrayList<>(tempList);
            listToAdd.sort((o1, o2) -> {
                if (o1>o2) return 1;
                else if (o1<o2) return -1;
                return 0;
            });

            if (!lists.contains(listToAdd)) lists.add(listToAdd);
        }
        else {
            for (int i=start; i<candidates.length; i++) {
                remain-=candidates[i];
                tempList.add(candidates[i]);
                for (int j:tempList)
                    System.out.println("in temp list j:" + j);
                System.out.println("added: " + candidates[i] + "remain: " + remain);
                backTrack(lists, tempList, candidates, remain, start);
                // unchoosing step
                tempList.remove(tempList.size()-1);
                remain+=candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        CombiSum c = new CombiSum();
        for (List<Integer> l:c.combinationSum(new int[]{1,2}, 4)) {
            for (int j:l) {
                System.out.println("j= " + j + ",");
            }
            System.out.println();
        }
    }
}
