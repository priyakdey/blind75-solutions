package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return s;

        int length = s.length();
        if (length == 1) return s;

        if (length == 2) {
            return s.charAt(0) == s.charAt(1) ? s : Character.toString(s.charAt(0));
        }

        int maxSubstrLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < length; i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int substrLength = (r - 1) - (l + 1) + 1;
            if (substrLength > maxSubstrLength) {
                left = l + 1;
                right = r - 1;
                maxSubstrLength = substrLength;
            }

            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                l = i - 1;
                r = i + 2;
                while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
            }

            substrLength = (r - 1) - (l + 1) + 1;
            if (substrLength > maxSubstrLength) {
                left = l + 1;
                right = r - 1;
                maxSubstrLength = substrLength;
            }
        }

        return s.substring(left, right + 1);
    }


}
