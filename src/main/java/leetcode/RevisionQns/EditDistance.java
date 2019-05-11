package main.java.leetcode.RevisionQns;

/*
72. Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for (int i=0;i<l1+1;i++) {
            for (int j=0;j<l2+1;j++) {
                if (i==0||j==0) dp[i][j]=i+j;
                else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;// for insert/delete
                    dp[i][j]=word1.charAt(i-1)==word2.charAt(j-1)?
                            Math.min(dp[i-1][j-1],dp[i][j]):Math.min(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse","ros"));
        System.out.println(ed.minDistance("intention","execution"));
    }
}
