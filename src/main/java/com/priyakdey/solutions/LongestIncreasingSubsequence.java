package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] maxLengthFrom = new int[length];

        maxLengthFrom[length - 1] = 1;

        int maxLength = 1;

        for (int i = length - 2; i >= 0; i--) {
            int localMaxLength = 0;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[i]) {
                    localMaxLength = Math.max(localMaxLength, maxLengthFrom[j]);
                }
            }
            maxLengthFrom[i] = localMaxLength + 1;
            maxLength = Math.max(maxLength, maxLengthFrom[i]);
        }

        return maxLength;
    }

}
