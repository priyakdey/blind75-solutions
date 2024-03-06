package com.priyakdey.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) throw new IllegalArgumentException("invalid input");
        if (m == 1 || n == 1) return 1;

        int[] ways = new int[n];
        Arrays.fill(ways, 1);

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                ways[col] = ways[col] + ways[col + 1];
            }
        }

        return ways[0];
    }

}
