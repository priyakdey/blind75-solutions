package com.priyakdey.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        if (length == 2) return new int[]{0, 1};

        Map<Integer,Integer> elementIndexMap = new HashMap<>();
        int[] indices = new int[2];

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int compliment = target - num;

            if (elementIndexMap.containsKey(compliment)) {
                indices[0] = elementIndexMap.get(compliment);
                indices[1] = i;
                break;
            }

            elementIndexMap.put(num, i);
        }

        return indices;
    }

}
