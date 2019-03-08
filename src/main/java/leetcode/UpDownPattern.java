package main.java.leetcode;

public class UpDownPattern {
    public boolean find132pattern(int[] nums) {
        // find the min in the beginning parts
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k])
                    return true;
            }
        }
        return false;
    }

    /*
    public boolean find132pattern(int[] nums) {
        List < int[] > intervals = new ArrayList < > ();
        int i = 1, s = 0;
        while (i < nums.length) {
            if (nums[i] <= nums[i - 1]) {
                if (s < i - 1)
                    intervals.add(new int[] {nums[s], nums[i - 1]});
                s = i;
            }
            for (int[] a: intervals)
                if (nums[i] > a[0] && nums[i] < a[1])
                    return true;
            i++;
        }
        return false;
    }


     */

    public static void main(String[] args) {
        UpDownPattern u = new UpDownPattern();
        System.out.println(u.find132pattern(new int[]{1,2,3,4}));
        System.out.println(u.find132pattern(new int[]{3,1,4,2}));
        System.out.println(u.find132pattern(new int[]{-1,3,2,0}));
    }
}
