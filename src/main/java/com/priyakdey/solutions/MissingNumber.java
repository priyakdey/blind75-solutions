package com.priyakdey.solutions;

/**
 * @author Priyak Dey
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (n * (n + 1) / 2) - sum;
    }

}
