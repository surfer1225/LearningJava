package main.java.leetcode;

/**
 * Created by Ryan on 2/12/17.
 */
public class RemoveDuplicatesInSortedArr {
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l <= 1) return l;
        int initial = nums[0];
        int i = 1;
        while (i < l) {
            if (nums[i] == initial) {
                for (int j = i; j < l-1; j++) {
                    nums[j] = nums[j+1];
                }
                l--;
            }
            else {
                initial = nums[i];
                i++;
            }
            print(l, nums);
        }

        return l;
    }

    private static void print(int l, int[] nums) {
        for (int m=0; m<l; m++) {
            System.out.print(nums[m] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 1, 2}));
    }
}
