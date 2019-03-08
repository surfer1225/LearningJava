package main.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajorityElementII {
    // check Boyer-Moore Majority Vote Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int l=nums.length,k=l/3;
        if (l==0) return new LinkedList<>();
        if (l==1) return Collections.singletonList(nums[0]);

        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int temp = nums[0], cnt=1;

        for (int i=1;i<l;i++) {
            if (nums[i]==temp) cnt++;
            else {
                if (cnt>k) list.add(temp);
                temp=nums[i];
                cnt=1;
            }
        }
        if (cnt>k) list.add(temp);
        return list;
    }
}
