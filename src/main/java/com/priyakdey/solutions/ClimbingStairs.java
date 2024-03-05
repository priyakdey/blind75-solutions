package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 1) throw new IllegalArgumentException("invalid input");

        int previous = 1, current = 2;
        for (int i = 2; i <= n; i++) {
            int temp = previous;
            previous = current;
            current = temp + current;
        }

        return previous;
    }

}
