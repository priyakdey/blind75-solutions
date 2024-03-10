package com.priyakdey.solutions;

import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/decode-ways/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class DecodeWays {

    public int numDecodings(String s) {
        Set<String> keys =
            Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26");

        Integer[] cache = new Integer[s.length() + 1];
        // return numDecodingsRecursive(s, 0, keys, cache);
        return numDecodingsTabulation(s, keys);
    }

    private int numDecodingsTabulation(String s, Set<String> keys) {
        int length = s.length();
        int[] cache = new int[length + 1];

        cache[cache.length - 1] = 1;

        for (int i = cache.length - 2; i >= 0; i--) {
            int count = 0;
            if (keys.contains(s.substring(i, i + 1))) {
                count += cache[i + 1];
            }

            if (i + 2 <= length && keys.contains(s.substring(i, i + 2))) {
                count += cache[i + 2];
            }
            cache[i] = count;
        }

        return cache[0];
    }


    private int numDecodingsRecursive(String s, int index, Set<String> keys, Integer[] cache) {
        if (index == s.length()) return 1;

        if (cache[index] != null) {
            return cache[index];
        }

        int count = 0;

        if (keys.contains(s.substring(index, index + 1))) {
            count += numDecodingsRecursive(s, index + 1, keys, cache);
        }

        if (index + 2 <= s.length() && keys.contains(s.substring(index, index + 2))) {
            count += numDecodingsRecursive(s, index + 2, keys, cache);
        }

        cache[index] = count;
        return count;
    }


}
