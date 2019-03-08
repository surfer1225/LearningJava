package main.java.leetcode.RevisionQns;

/*
518. Coin Change 2

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {

        int[] combinations = new int[amount + 1];
        combinations[0] = 1; // to allow single value res[1] = 1 when there is 1

        for (int coin: coins)
            for (int i = 1; i < combinations.length; i++)
                if (i >= coin)
                    combinations[i] += combinations[i - coin];

        return combinations[amount];
    }

    public static void main(String[] args) {
        CoinChangeII cc = new CoinChangeII();
        System.out.println(cc.change(3, new int[]{1,2,5}));
    }
}
