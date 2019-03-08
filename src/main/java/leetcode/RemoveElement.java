package main.java.leetcode;

/**
 * Created by Ryan on 14/12/17.
 */

/*
In-Place removal of elements, return new array size with elements removed
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int window = 0;
        for (int i=0;i<nums.length;i++) {
            nums[i-window]=nums[i];
            if (nums[i]==val) {
                window++;
            }
        }
        for (int j=0;j<window;j++) {
            System.out.print(nums[j]+", ");
        }
        System.out.println();
        return nums.length-window;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{4,5}, 5));
    }
}
