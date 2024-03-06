package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int length = prices.length;

        if (length == 1) return 0;
        if (length == 2) return prices[1] > prices[0] ? prices[1] - prices[0] : 0;

        int maxProfit = 0;
        int buyingPrice = prices[0];

        for (int price : prices) {
            buyingPrice = Math.min(buyingPrice, price);
            maxProfit = Math.max(maxProfit, price - buyingPrice);
        }

        return maxProfit;
    }

}
