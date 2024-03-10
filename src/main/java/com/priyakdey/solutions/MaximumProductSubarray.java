package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return max(nums[0] * nums[1], nums[0], nums[1]);

        int currMax = nums[0], currMin = nums[0], maxProduct = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] == 0) {
                currMax = 0;
                currMin = 0;
            } else {
                int tempCurrMax = max(nums[i], nums[i] * currMax, nums[i] * currMin);
                int tempCurrMin = min(nums[i], nums[i] * currMax, nums[i] * currMin);
                currMax = tempCurrMax;
                currMin = tempCurrMin;
            }

            maxProduct = max(maxProduct, currMax);
        }

        return maxProduct;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }

    private int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

}
