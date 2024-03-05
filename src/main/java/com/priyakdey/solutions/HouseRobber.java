package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/house-robber/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int maxLoot = nums[length - 1];
        int adjacentLoot = nums[length - 2];

        for (int i = length - 3; i >= 0; i--) {
            int currMaxLoot = nums[i] + maxLoot;
            maxLoot = Math.max(adjacentLoot, maxLoot);
            adjacentLoot = currMaxLoot;
        }

        return Math.max(adjacentLoot, maxLoot);
    }

}
