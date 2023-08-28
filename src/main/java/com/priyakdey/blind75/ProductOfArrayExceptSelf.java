package com.priyakdey.blind75;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] arr) {
        int length = arr.length;

        if (length == 2) return new int[]{arr[1], arr[0]};

        int[] product = new int[length];
        Arrays.fill(product, 1);

        int prefixProduct = 1, suffixProduct = 1;
        int left = 1, right = length - 2;

        while (left < length) {
            prefixProduct *= arr[left - 1];
            product[left] *= prefixProduct;
            left++;

            suffixProduct *= arr[right + 1];
            product[right] *= suffixProduct;
            right--;
        }

        return product;
    }

}
