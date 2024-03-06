package com.priyakdey.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();


        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return triplets;
    }

}
