package com.priyakdey.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) throw new IllegalArgumentException("invalid input");

        int length = nums.length;
        int[] productArray = new int[length];
        Arrays.fill(productArray, 1);

        int prefixProduct = 1, suffixProduct = 1;

        int left = 1, right = length - 2;

        while (left < length) {
            prefixProduct = prefixProduct * nums[left - 1];
            productArray[left] = productArray[left] * prefixProduct;
            left++;

            suffixProduct = suffixProduct * nums[right + 1];
            productArray[right] = productArray[right] * suffixProduct;
            right--;
        }

        return productArray;
    }

}
