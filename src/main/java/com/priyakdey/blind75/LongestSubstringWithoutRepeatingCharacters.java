package com.priyakdey.blind75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return s.length();
        if (length == 2) return s.charAt(0) == s.charAt(1) ? 1 : 2;

        Map<Character, Integer> charIndexMap = new HashMap<>();

        int start = 0, end = 0;
        int maxLength = 1;

        while (end < length) {
            char ch = s.charAt(end);
            if (charIndexMap.containsKey(ch) && charIndexMap.get(ch) >= start) {
                maxLength = Math.max(maxLength, end - 1 - start + 1);
                start = charIndexMap.get(ch) + 1;
            }

            charIndexMap.put(ch, end);
            end++;
        }

        // recalculate max length for case where end == length
        // and the substring has no repeating char
        maxLength = Math.max(maxLength, end - 1 - start + 1);

        return maxLength;
    }
}
