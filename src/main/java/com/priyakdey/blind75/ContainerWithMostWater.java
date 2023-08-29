package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int length = height.length;

        if (length == 2) return Math.min(height[0], height[1]);

        int left = 0, right = length - 1;
        int maxArea = 0;
        while (left < right) {
            int boundHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, boundHeight * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;

    }
}
