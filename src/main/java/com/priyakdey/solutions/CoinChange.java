package com.priyakdey.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // Integer[][] cache = new Integer[coins.length][amount + 1];
        // int count = coinChangeRec(coins, 0, amount, cache);
        int count = coinChangeTabulation(coins, amount);
        return count != Integer.MAX_VALUE ? count : -1;
    }

    private int coinChangeTabulation(int[] coins, int amount) {
        int[] cache = new int[amount + 1];

        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for (int currAmount = 1; currAmount < amount + 1; currAmount++) {
            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                int remainingAmount = currAmount - coin;
                if (remainingAmount >= 0 && cache[remainingAmount] != Integer.MAX_VALUE) {
                    count = Math.min(count, 1 + cache[remainingAmount]);
                }
            }
            cache[currAmount] = count;
        }

        return cache[amount];
    }

    private int coinChangeRec(int[] coins, int index, int amount, Integer[][] cache) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        if (cache[index][amount] != null) return cache[index][amount];

        int count = Integer.MAX_VALUE;

        for (int i = index, length = coins.length; i < length; i++) {
            int c = coinChangeRec(coins, i, amount - coins[i], cache);
            if (c != Integer.MAX_VALUE) {
                count = Math.min(count, 1 + c);
            }
        }

        cache[index][amount] = count;
        return count;
    }
}
