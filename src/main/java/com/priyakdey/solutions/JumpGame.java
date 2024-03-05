package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/jump-game/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        if (length == 1) return true;
        if (length == 2) return nums[0] != 0;

        int destination = length - 1;

        for (int i = length - 2; i >= 0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }

        return destination == 0;
    }

}
