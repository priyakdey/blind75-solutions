package com.priyakdey.blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Integer, Integer> codePointCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int codePoint = s.codePointAt(i);
            codePointCountMap.compute(codePoint, (k, v) -> v != null ? v + 1 : 1);
        }

        boolean isAnagram = true;

        for (int i = 0; i < t.length(); i++) {
            int codePoint = t.codePointAt(i);
            if (!codePointCountMap.containsKey(codePoint)) {
                isAnagram = false;
                break;
            }

            codePointCountMap.computeIfPresent(codePoint, (k, v) -> v > 1 ? v - 1 : null);
        }

        return isAnagram;
    }


    // @NOTE: This is faster solution, using the std lib constructs
    public boolean _isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCodePoints = s.codePoints().sorted().toArray();
        int[] tCodePoints = t.codePoints().sorted().toArray();

        return Arrays.equals(sCodePoints, tCodePoints);
    }
}
