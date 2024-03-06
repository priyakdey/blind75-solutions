package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) return nums[0] == target ? 0 : -1;

        int index = -1;
        int left = 0, right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] <= nums[length - 1]) {
                // mid landed on the right sorted section
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    if (target <= nums[length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                // mid landed on the left sorted section
                if (target < nums[mid]) {
                    if (target >= nums[0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            }
        }

        return index;

    }

}
