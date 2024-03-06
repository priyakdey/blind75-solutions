package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int setCount = 0;
        for (int i = 0; i < 32; i++) {
            setCount += n & 1;
            n = n >>> 1;
        }

        return setCount;
    }

}
