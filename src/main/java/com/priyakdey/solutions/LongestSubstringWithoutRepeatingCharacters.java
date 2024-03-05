package com.priyakdey.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Objects.requireNonNull(s);
        int length = s.length();

        if (s.isEmpty()) return 0;
        if (length == 1) return 1;
        if (length == 2) return s.charAt(0) != s.charAt(1) ? 2 : 1;

        Map<Character, Integer> charIndexMap = HashMap.newHashMap(length);

        int start = 0, curr = 0;
        int maxSubstrLength = 1;

        while (curr < length) {
            char ch = s.charAt(curr);
            if (charIndexMap.containsKey(ch) && charIndexMap.get(ch) >= start) {
                maxSubstrLength = Math.max(maxSubstrLength, curr - 1 - start + 1);
                start = charIndexMap.get(ch) + 1;
            }
            charIndexMap.put(ch, curr);
            curr++;
        }

        maxSubstrLength = Math.max(maxSubstrLength, curr - 1 - start + 1);
        return maxSubstrLength;
    }

}
