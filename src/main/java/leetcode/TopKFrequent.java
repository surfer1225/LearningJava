package main.java.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n:nums) m.put(n,m.getOrDefault(n,0)+1);

        return m.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        System.out.println(t.topKFrequent(new int[]{1,2,2,3,1,1},2));
    }
}
