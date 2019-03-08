package main.java.leetcode.RevisionQns;

/**
 * Created by Ryan on 17/12/17.
 */

public class MaxStockPx {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.

    Example 1:
    Input: [7, 1, 5, 3, 6, 4]
    Output: 5

    max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     */
    public int maxProfitWithOneTransaction(int[] prices) {
        if (prices.length<=1) return 0;
        int min=prices[0]<prices[1]?prices[0]:prices[1];
        int res=prices[1]-prices[0]<0?prices[1]-prices[0]:0;
        for (int i=1;i<prices.length;i++) {
            min=prices[i]<min?prices[i]:min;
            res=prices[i]-min<res?res:prices[i]-min;
        }
        return res;
    }

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (ie, buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time
    (ie, you must sell the stock before you buy again).
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int sum=0;
        for (int i=1;i<prices.length;i++) {
            sum+=(prices[i]-prices[i-1]>0?prices[i]-prices[i-1]:0);
        }
        return sum;
    }

    /*
    Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
    and a non-negative integer fee representing a transaction fee.

    You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
    You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

    Return the maximum profit you can make.

    Example 1:
    Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
    Output: 8
    Explanation: The maximum profit can be achieved by:
    Buying at prices[0] = 1
    Selling at prices[3] = 8
    Buying at prices[4] = 4
    Selling at prices[5] = 9
    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     */
    public int maxProfit(int[] prices, int fee) {
        /*
        Intuition and Algorithm
        At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of stock,
        and hold, the maximum profit we could have if we owned a share of stock.

        To transition from the i-th day to the i+1-th day, we either sell our stock cash = max(cash, hold + prices[i] - fee)
        or buy a stock hold = max(hold, cash - prices[i]).
        At the end, we want to return cash. We can transform cash first without using temporary variables because selling and
        buying on the same day can't be better than just continuing to hold the stock.
         */
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
            System.out.println("cash & hold on day i: " + cash + ", " + hold + ", " + " at day " + i);
        }
        return cash;
    }

    public static void main(String[] args) {
        MaxStockPx m = new MaxStockPx();
        System.out.println(m.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println(m.maxProfit(new int[]{7,1,3,2,8,4,9}, 2));
//        System.out.println(m.maxProfit(new int[]{2,2,1,1,5,5,3,1,5,4}, 2));
//        System.out.println(m.maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4}, 1));
    }
}
