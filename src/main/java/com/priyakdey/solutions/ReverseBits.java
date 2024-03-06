package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = n & 1;
            reverse = reverse | (bit << i);
            n = n >>> 1;
        }

        return reverse;
    }

}
