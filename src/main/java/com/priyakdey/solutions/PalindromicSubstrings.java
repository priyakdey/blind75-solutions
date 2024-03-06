package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/palindromic-substrings/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = s.length();
        int count = 0;

        if (length == 1) return 1;
        if (length == 2) return s.charAt(0) == s.charAt(1) ? 3 : 2;

        for (int i = 0; i < length; i++) {
            count++;
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                }
            }
        }

        return count;
    }

}
