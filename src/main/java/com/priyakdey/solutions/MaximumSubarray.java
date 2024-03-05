package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];

        int maxSumOverall = nums[0];
        int maxSumTill = nums[0];

        for(int i = 1; i < length; i++) {
            int num = nums[i];
            maxSumTill = Math.max(num, maxSumTill + num);
            maxSumOverall = Math.max(maxSumTill, maxSumOverall);
        }

        return maxSumOverall;
    }

}
