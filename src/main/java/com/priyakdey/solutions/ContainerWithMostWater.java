package com.priyakdey.solutions;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        Objects.requireNonNull(heights);
        int length = heights.length;
        if (length < 2) {
            throw new IllegalArgumentException("invalid input");
        }

        int left = 0, right = length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftBoundHeight  = heights[left];
            int rightBoundHeight = heights[right];
            int area = Math.min(leftBoundHeight, rightBoundHeight) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (leftBoundHeight <= rightBoundHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
