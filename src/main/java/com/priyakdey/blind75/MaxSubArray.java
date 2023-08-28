package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        int maxSumOverall = nums[0], maxSumTill = nums[0];

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            maxSumTill = Math.max(num, maxSumTill + num);
            maxSumOverall = Math.max(maxSumTill, maxSumOverall);
        }

        return maxSumOverall;
    }
}
