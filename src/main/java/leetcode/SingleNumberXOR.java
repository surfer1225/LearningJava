package main.java.leetcode;

/**
 * Created by Ryan on 26/12/17.
 */
public class SingleNumberXOR {
    // find the only number that appears once only
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i<nums.length; i++)
        {
            result ^=nums[i];
        }
        return result;
    }
}
