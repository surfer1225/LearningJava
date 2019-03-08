package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
368. Largest Divisible Subset

Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        /*
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> endsList = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(nums[i]));
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0 && endsList.get(j).size() + 1 > list.size()) {
                    list = new ArrayList<>(endsList.get(j));
                    list.add(nums[i]);
                }
            }
            result = list.size() > result.size() ? list : result;
            endsList.add(list);
        }
        return result;
         */
        Arrays.sort(nums);
        List<List<Integer>> l = new LinkedList<>();

        for (int i=0;i<nums.length;i++) {
            boolean added = false;
            List<List<Integer>> toAdd = new LinkedList<>();
            for (List<Integer> temp:l) {
                if (nums[i]%temp.get(temp.size()-1)==0) {
                    List<Integer> copy = new LinkedList<>(temp);
                    copy.add(nums[i]);
                    toAdd.add(copy);
                    added=true;
                }
            }
            if (!added) l.add(new LinkedList<>(Collections.singletonList(nums[i])));
            else {
                List<Integer> tempMax = new LinkedList<>();
                for (List<Integer> list:toAdd) {
                    if (list.size()>tempMax.size()) tempMax = list;
                }
                l.add(tempMax);
            }
        }

        List<Integer> max = new LinkedList<>();
        for (List<Integer> temp:l) {
            if (temp.size()>max.size()) max=temp;
        }
        return max;
    }
}
