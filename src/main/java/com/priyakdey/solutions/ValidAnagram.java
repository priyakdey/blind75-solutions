package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] countArr = new int[26];

        mutateCountArray(countArr, s, 1);
        mutateCountArray(countArr, t, -1);

        int zeroCount = 0;
        for (int count : countArr) {
            if (count == 0) {
                zeroCount++;
            }
        }

        return zeroCount == 26;
    }

    private void mutateCountArray(int[] countArr, String word, int incrementBy) {
        for (char ch : word.toCharArray()) {
            int index = ch - 97;
            countArr[index] += incrementBy;
        }
    }

}
