package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int length = nums.length;

        // [0] -> max product till
        // [1] -> min product till
        int[][] currMaxMinProduct = new int[length + 1][2];

        int maxProduct = nums[0];
        currMaxMinProduct[0] = new int[]{1, 1};

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == 0) {
                // reset the {}max, min} to {1, 1} to avoid zero for all next iterations
                currMaxMinProduct[i] = new int[]{1, 1};
                // calculate max against zero, because all other products might be -ve
                maxProduct = Math.max(maxProduct, 0);
                continue;
            }

            int p1 = currMaxMinProduct[i - 1][0] * num;
            int p2 = currMaxMinProduct[i - 1][1] * num;
            currMaxMinProduct[i] = new int[]{Math.max(p1, p2), Math.min(p1, p2)};
            maxProduct = Math.max(maxProduct, currMaxMinProduct[i][0]);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        new MaximumProductSubarray().maxProduct(new int[]{0, 2});
    }

}
