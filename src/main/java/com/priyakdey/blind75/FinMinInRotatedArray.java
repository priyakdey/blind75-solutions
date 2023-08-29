package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class FinMinInRotatedArray {

    public int findMin(int[] nums) {
        int length = nums.length;

        if (length == 1) return nums[0];
        if (length == 2) return Math.min(nums[0], nums[1]);

        int left = 0, right = length - 1;
        int minElement = -1;        // This will be overwritten in at least once case
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[length - 1]) {
                // mid is on the right sorted half
                minElement = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return minElement;
    }
}
