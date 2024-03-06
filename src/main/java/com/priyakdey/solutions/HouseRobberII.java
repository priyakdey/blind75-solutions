package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class HouseRobberII {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int nextMaxLoot = nums[length - 2];
        int adjacentLoot = nums[length - 3];

        for (int i = length - 4; i >= 0; i--) {
            int currMaxLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(adjacentLoot, nextMaxLoot);
            adjacentLoot = currMaxLoot;
        }

        int totalMaxLoot = Math.max(adjacentLoot, nextMaxLoot);

        nextMaxLoot = nums[length - 1];
        adjacentLoot = nums[length - 2];

        for (int i = length - 3; i >= 1; i--) {
            int currMaxLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(adjacentLoot, nextMaxLoot);
            adjacentLoot = currMaxLoot;
        }

        return Math.max(totalMaxLoot, Math.max(adjacentLoot, nextMaxLoot));
    }

}
