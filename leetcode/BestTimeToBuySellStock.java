/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

import java.util.Set;
import java.util.HashSet;

class BestTimeToBuySellStock {

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    //int[] prices = {7,6,4,3,1};
    //int[] prices = {2,1,2,1,0,1,2};
    //int[] prices = {3,3,5,0,0,3,1,4};
    int maxp = maxProfit(prices);
    p(maxp);
  }

  public static void p(int x) {
    System.out.println(x);
  }

  public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minSoFar = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i-1]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
  }
}

