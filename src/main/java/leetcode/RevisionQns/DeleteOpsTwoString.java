package main.java.leetcode.RevisionQns;

public class DeleteOpsTwoString {

    public int minOpsEqual(String a, String b) {
        int al = a.length();
        int bl = b.length();

        int[][] dp = new int[al+1][bl+1];

        for (int i=0;i<al+1;i++) {
            for (int j=0;j<bl+1;j++) {
                if (i==0||j==0) dp[i][j]=i+j;
                else if (a.charAt(i-1)==b.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
            }
        }

        return dp[al][bl];
    }
}
