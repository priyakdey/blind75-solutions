package com.priyakdey.solutions;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length <= 1) return length;
        if (length == 2) return nums[0] + 1 == nums[1] || nums[0] - 1 == nums[1] ? 2 : 1;

        Set<Integer> toBeProcessed = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int maxRange = 1;

        for (int num : nums) {
            if (toBeProcessed.contains(num)) {
                int upperBound = num;
                while (toBeProcessed.contains(upperBound)) {
                    toBeProcessed.remove(upperBound);
                    upperBound++;
                }

                int lowerBound = num - 1;
                while (toBeProcessed.contains(lowerBound)) {
                    toBeProcessed.remove(lowerBound);
                    lowerBound--;
                }

                int range = (upperBound - 1) - (lowerBound + 1) + 1;
                maxRange = Math.max(maxRange, range);
            }
        }

        return maxRange;
    }

}
