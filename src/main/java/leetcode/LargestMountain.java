package main.java.leetcode;

/*
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
 */

public class LargestMountain {
    /*
    class Solution {
        public int longestMountain(int[] A) {
            int N = A.length;
            int ans = 0, base = 0;
            while (base < N) {
                int end = base;
                // if base is a left-boundary
                if (end + 1 < N && A[end] < A[end + 1]) {
                    // set end to the peak of this potential mountain
                    while (end + 1 < N && A[end] < A[end + 1]) end++;

                    // if end is really a peak..
                    if (end + 1 < N && A[end] > A[end + 1]) {
                        // set end to the right-boundary of mountain
                        while (end + 1 < N && A[end] > A[end + 1]) end++;
                        // record candidate answer
                        ans = Math.max(ans, end - base + 1);
                    }
                }

                base = Math.max(end, base + 1);
            }

            return ans;
        }
    }
     */
    public int longestMountain(int[] A) {
        if (A.length<3) return 0;

        int l=0, max=0;
        boolean firstHalf = true;

        for (int i=1;i<A.length;i++) {
            if (A[i]==A[i-1]) {
                max=Math.max(max,i-l);
                l=i;
                continue;
            }
            if (firstHalf) {
                if (A[i]<A[i-1]) {
                    if (i-1==l) {//no first half mountain
                        l=i;
                        continue;
                    }
                    else firstHalf=false;
                }
            }
            else {
                if (A[i]>A[i-1]) {
                    max=Math.max(max,i-l);
                    l=i-1;
                    firstHalf=true;
                }
            }
            if (A.length-1==i && !firstHalf) max=Math.max(max,i-l+1);
        }

        return max>=3?max:0;
    }

    public static void main(String[] args) {
        LargestMountain lm = new LargestMountain();
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,2}));
        System.out.println(lm.longestMountain(new int[]{2,2,2,2,2,2,2}));
        System.out.println(lm.longestMountain(new int[]{5,4,3,2,1}));
        System.out.println(lm.longestMountain(new int[]{0,1,0}));
    }
}
