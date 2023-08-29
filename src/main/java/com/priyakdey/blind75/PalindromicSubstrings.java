package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 1) return 1;

        int count = 0;

        for (int i = 0; i < length; i++) {
            count++;        // This is for the palindrome s[i]

            // try and expand from ith position for odd length palindrome
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }

            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;        // This is for the palindrome s[i : i+2]

                // try and expand from ith and i+1 the position for even length palindrome
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
            }
        }

        return count;
    }
}
