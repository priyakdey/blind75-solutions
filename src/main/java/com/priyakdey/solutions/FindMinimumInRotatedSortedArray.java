package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.min(nums[0], nums[1]);

        int left = 0, right = length - 1;

        int min = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[length - 1]) {
                min = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

}
