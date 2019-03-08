package main.java.leetcode.RevisionQns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
474. Ones and Zeroes

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand,
there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

 */
public class OnesZeros {
    /*
    public int findMaxForm(String[] strs, int m, int n) {
        int [] ms = new int[strs.length];
        int [] ns = new int[strs.length];
        for(int i =0; i<strs.length;++i){
            String s = strs[i];
            for(int j=0; j<s.length();++j){
                if (s.charAt(j)=='0')++ms[i];
                else ++ns[i];
            }
        }
        int [][][] dp = new int[m+1][n+1][strs.length+1];
        for(int i=0; i<ms.length;++i){
            for(int mm = 0; mm<=m;++mm){
                for(int nn= 0; nn<=n;++nn){
                    dp[mm][nn][i+1]=(mm>=ms[i]&&nn>=ns[i])?Math.max(dp[mm][nn][i],dp[mm-ms[i]][nn-ns[i]][i]+1):dp[mm][nn][i];
                }
            }
        }
        return dp[m][n][strs.length];
    }

     */

    /*
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int[] count = count(s);
            for (int i=m;i>=count[0];i--)
                for (int j=n;j>=count[1];j--)
                    dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
        }
        return dp[m][n];
    }

    public int[] count(String str) {
        int[] res = new int[2];
        for (int i=0;i<str.length();i++)
            res[str.charAt(i) - '0']++;
        return res;
    }
     */

    class ZeroOne {
        int zero;//count of 0
        int one;//count of 1
    }

    int cnt=-1;

    public int findMaxForm(String[] strs, int m, int n) {
        List<ZeroOne> helper = new ArrayList<>();
        for (String str:strs) {
            helper.add(mapString(str));
        }
        int cnt1=0,cnt0=0;
        for (ZeroOne zo:helper) { cnt1+=zo.one; cnt0+=zo.zero; }
        backtrack(helper, cnt1, cnt0, n, m);
        return cnt;
    }

    private ZeroOne mapString(String s) {
        ZeroOne zo = new ZeroOne();
        int ones=0,zeros=0;
        for (char c:s.toCharArray()) {
            if (c=='0') zeros++;
            else ones++;
        }
        zo.one=ones;
        zo.zero=zeros;
        return zo;
    }

    private void backtrack(List<ZeroOne> l, int cnt1, int cnt0, int target1, int target0) {
        l.forEach(z -> System.out.print(z.one + "," + z.zero + ";"));
        System.out.println();
        if (l.size()<cnt) return;
        if (cnt0<=target0 && cnt1<=target1) {
            cnt=Math.max(l.size(),cnt);
            return;
        }

        for (int i=0;i<l.size();i++) {
            ZeroOne zo = l.remove(i);
            backtrack(new LinkedList<>(l), cnt1-zo.one, cnt0-zo.zero, target1, target0);
            l.add(i,zo);
        }
    }

    public static void main(String[] args) {
        OnesZeros o = new OnesZeros();
        //System.out.println(o.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(o.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
