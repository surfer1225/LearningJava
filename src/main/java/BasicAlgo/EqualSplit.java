package main.java.BasicAlgo;

/*
Problem Given n items with weights w1, w2 . . . , wn,
determine whether or not there is a way to divide up the items into two sets B1 and B2 such that
sum(wi) = sum(wj). wi ∈B1 wj ∈B2
 */
public class EqualSplit {
    public boolean canPartition(int[] nums) {
        //one important observation is that, if we have to partition it into the
        //two subsets , each suset sum will be equal to half of the total sum
        //lets calculate the total sum first
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //first thing is that the sum should be divisible by 2
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;//this is for which if find a subset, that we can say that it can be partitioned
        return subsetSum(nums, target);
    }

    //standard subsetSum tabulation dp
    private boolean subsetSum(int nums[], int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (target > nums[0]) dp[0][nums[0]] = true;
        //apply the dp formula for subsetsum. for all other values
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    //there are two cases, either to include the current number in set or not
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }
}
