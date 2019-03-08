package main.java.DataStructure.Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ryan on 11/1/18.
 */
/*
Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function,
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MovingZeros {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<l;i++) {
            if (nums[i]==0) q.add(i);
            else if (!q.isEmpty()) {
                int tempIndex = q.poll();
                int temp = nums[i];
                nums[i] = nums[tempIndex];
                nums[tempIndex] = temp;
                q.offer(i);
            }
        }
    }

    public static void main(String[] args) {
        MovingZeros m = new MovingZeros();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        m.moveZeroes(arr);
        for (int n:arr) System.out.println(n);
    }
}
