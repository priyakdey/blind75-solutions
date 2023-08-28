package com.priyakdey.blind75;

import java.util.Set;
import java.util.HashSet;

/**
 * @author Priyak Dey
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visitedElements = new HashSet<>();

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
