package main.java.leetcode.RevisionQns;

/*
128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> unvisited = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max=0;
        for (int n:nums) {
            int curCnt = 0, curNum = n;
            while (unvisited.contains(curNum)) {
                ++curCnt;
                unvisited.remove(curNum);
                ++curNum;
            }
            curNum = n-1;
            while (unvisited.contains(curNum)) {
                ++curCnt;
                unvisited.remove(curNum);
                --curNum;
            }
            max=Math.max(max,curCnt);
        }
        return max;
    }
    /*
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int n:nums) numMap.put(n,0);

        int max = 0;
        for (int n:nums) {
            int curCnt = 0, cur = n;
            while (numMap.containsKey(cur)) {
                if (numMap.get(cur)>0) {
                    curCnt+=numMap.get(cur);
                    break;
                }
                else {
                    ++curCnt;
                    ++cur;
                }
            }

            max = Math.max(curCnt,max);

            cur = n;
            while (numMap.getOrDefault(cur,-1)==0) {
                numMap.put(cur,curCnt--);
            }
        }

        return max;
    }

     */

    public static void main(String[] args) {
        LongestConsecSeq l = new LongestConsecSeq();
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
