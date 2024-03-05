package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        // int length1 = text1.length(), length2 = text2.length();
        // Integer[][] cache = new Integer[length1 + 1][length2 + 1];
        // return longestCommonSubsequence(text1, 0, text2, 0, cache);

        return longestCommonSubsequenceTabulation(text1, text2);
    }

    private int longestCommonSubsequenceTabulation(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] cache = new int[length1 + 1][length2 + 1];

        for (int index1 = length1 - 1; index1 >= 0; index1--) {
            int maxLength = 0;
            for (int index2 = length2 - 1; index2 >= 0; index2--) {
                if (text1.charAt(index1) == text2.charAt(index2)) {
                    maxLength = Math.max(maxLength, 1 + cache[index1 + 1][index2 + 1]);
                }
                maxLength = max(maxLength, cache[index1][index2 + 1], cache[index1 + 1][index2]);
                cache[index1][index2] = maxLength;
            }
        }

        return cache[0][0];
    }


    private int longestCommonSubsequence(String text1, int index1, String text2, int index2,
                                         Integer[][] cache) {
        if (index1 == text1.length() || index2 == text2.length()) return 0;

        if (cache[index1][index2] != null) {
            return cache[index1][index2];
        }

        int maxLength = 0;

        if (text1.charAt(index1) == text2.charAt(index2)) {
            maxLength = 1 + longestCommonSubsequence(text1, index1 + 1, text2, index2 + 1, cache);
        }

        maxLength = max(
            maxLength,
            longestCommonSubsequence(text1, index1 + 1, text2, index2, cache),
            longestCommonSubsequence(text1, index1, text2, index2 + 1, cache)
        );
        cache[index1][index2] = maxLength;
        return maxLength;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
