package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/counting-bits/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] bitCountArr = new int[n + 1];
        bitCountArr[0] = 0;

        int nextPowerOfTwo = 1;
        int prevPowerOfTwo = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i == nextPowerOfTwo) {
                bitCountArr[i] = 1;
                prevPowerOfTwo = nextPowerOfTwo;
                nextPowerOfTwo = nextPowerOfTwo << 1;
            } else {
                bitCountArr[i] = 1 + bitCountArr[i - prevPowerOfTwo];
            }
        }

        return bitCountArr;
    }


}
