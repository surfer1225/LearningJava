package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 16/12/17.
 */

/*
search for position to insert a target number into an array
 */
public class SearchInsertPos {

    public int searchInsert(int[] nums, int target) {
        if (target>nums[nums.length-1]) return nums.length;
        else if (target<=nums[0]) return 0;

        return searchInsertHelper(nums, 0, nums.length-1, target);
    }

    private int searchInsertHelper(int[] nums, int low, int high, int target) {
        if (low>=high) return -1;
        int mid = (low + high) / 2;
        if (mid<high) {
            if (target<=nums[mid+1]&&target>nums[mid]) return mid+1;
            else if (nums[mid]>=target) return searchInsertHelper(nums, low, mid, target);
            else return searchInsertHelper(nums, mid, high, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsertPos sip = new SearchInsertPos();
        System.out.println(sip.searchInsert(new int[]{1,3,4,5,6,8,10}, 5));
    }
}
