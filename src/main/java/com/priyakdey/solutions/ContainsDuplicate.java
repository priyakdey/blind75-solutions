package com.priyakdey.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return false;

        Set<Integer> visitedElements = HashSet.newHashSet(length);
        boolean hasDuplicates = false;

        for (int num : nums) {
            if (visitedElements.contains(num)) {
                hasDuplicates = true;
                break;
            }

            visitedElements.add(num);
        }

        return hasDuplicates;
    }

}
