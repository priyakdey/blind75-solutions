package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/sum-of-two-integers/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class SumOfTwoInteger {

    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;

        for (int i = 0; i < 32; i++) {
            int bit1 = a & 1;
            int bit2 = b & 1;
            int[] result = getSum(bit1, bit2, carry);
            int bit = result[1];
            carry = result[0];
            sum = sum | (bit << i);
            a = a >>> 1;
            b = b >>> 1;
        }

        return sum;
    }

    private int[] getSum(int a, int b, int carry) {
        if (a == 0 && b == 0 && carry == 0) return new int[] {0, 0};
        if (a == 0 && b == 0 && carry == 1) return new int[] {0, 1};
        if (a == 0 && b == 1 && carry == 0) return new int[] {0, 1};
        if (a == 0 && b == 1 && carry == 1) return new int[] {1, 0};
        if (a == 1 && b == 0 && carry == 0) return new int[] {0, 1};
        if (a == 1 && b == 0 && carry == 1) return new int[] {1, 0};
        if (a == 1 && b == 1 && carry == 0) return new int[] {1, 0};
        if (a == 1 && b == 1 && carry == 1) return new int[] {1, 1};

        throw new IllegalArgumentException("invalid input");
    }

}
