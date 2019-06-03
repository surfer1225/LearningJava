package main.java.DataStructure.Array;

/**
 * Created by Ryan on 30/12/17.
 */

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class MinSortedArr {
    public int findMin(int[] nums) {
        /*
        int size = nums.length;
        if (size==1) return nums[0];
        int low = 0, high = size-1;

        while (low<=high) {
            if (nums[high]>nums[low]) return nums[low];
            int mid = (low + high) / 2;
            if (mid>0 && nums[mid]<nums[mid-1]) return nums[mid];
            if (nums[mid]>nums[high]) low=mid+1;
            else if (nums[mid]<nums[low]) high=mid-1;
        }

        return -1;
         */
        if (nums.length==1) return nums[0];
        int res = findMinHelper(nums, 0, nums.length-1);
        return res==-1?nums[0]:nums[res];
    }

    private int findMinHelper(int[] nums, int start, int end) {
        if (start>end) return -1;
        int mid = (start+end)/2;
        System.out.println(nums[mid]);
        if (mid>0&&nums[mid]<nums[mid-1]) return mid;
        int res = findMinHelper(nums, start, mid-1);
        return res==-1?findMinHelper(nums, mid+1, end):res;
    }
}
