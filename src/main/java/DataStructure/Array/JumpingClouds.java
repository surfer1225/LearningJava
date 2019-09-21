package main.java.DataStructure.Array;

public class JumpingClouds {
    public int jumpingCloud(int[] c) {
        int[] dp = new int[c.length];

        dp[0] = 0;
        dp[1] = c[1]==0?1:Integer.MAX_VALUE;

        for (int i=2;i<c.length;++i) {
            if (c[i]==1) {
                dp[i] = Integer.MAX_VALUE;
            }
            else {
                dp[i] = Math.min(dp[i-1],dp[i-2])+1;
            }
        }

        return dp[c.length-1];
    }

    public static void main(String[] args) {
        JumpingClouds jc = new JumpingClouds();
        System.out.println(jc.jumpingCloud(new int[]{0,0,1,0,0,1,0}));
        System.out.println(jc.jumpingCloud(new int[]{0,0,0,0,1,0}));
        System.out.println(jc.jumpingCloud(new int[]{0,0,0,1,0,0}));
    }
}
