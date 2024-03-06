package com.priyakdey.solutions;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        Objects.requireNonNull(s);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char chLeft  = s.charAt(left);
            char chRight = s.charAt(right);

            if (isAlpha(chLeft) && isAlpha(chRight)) {
                if (!isSame(chLeft, chRight)) return false;
                left++;
                right--;
            } else if (isAlpha(chLeft) && !isAlpha(chRight)) {
                right--;
            } else if (!isAlpha(chLeft) && isAlpha(chRight)) {
                left++;
            } else {
                // (!isAlpha(s.charAt(left)) && !isAlpha(s.charAt(right)))
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isSame(char ch1, char ch2) {
        return (ch1 == ch2) || (ch1 ^ 32) == ch2 || ch1 == (ch2 ^ 32);
    }


    private boolean isAlpha(char ch) {
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57);
    }

}
