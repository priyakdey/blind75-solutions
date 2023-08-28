package com.priyakdey.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // avoids duplicate and improves performance
                continue;
            }

            int num = nums[i];
            List<List<Integer>> tripletsForNum =  findTripletsFor(nums, i + 1, num);

            if (!tripletsForNum.isEmpty()) {
                tripletsForNum.stream().collect(Collectors.toCollection(() -> triplets));
            }
        }

        return triplets;
    }

    private List<List<Integer>> findTripletsFor(int[] nums, int start, int num) {
        List<List<Integer>> triplets = new ArrayList<>();

        int compliment = 0 - num;
        int left = start, right = nums.length - 1;

        while (left < right) {
            if (left > start && nums[left] == nums[left - 1]) {
                // avoids duplicate and improves performance
                left++;
                continue;
            }

            if (nums[left] + nums[right] == compliment) {
                triplets.add(List.of(num, nums[left], nums[right]));
                left++;
                right--;
            } else if (nums[left] + nums[right] > compliment) {
                right--;
            } else {
                left++;
            }
        }

        return triplets;
    }

}
