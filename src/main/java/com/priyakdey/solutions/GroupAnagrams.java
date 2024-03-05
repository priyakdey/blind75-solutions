package com.priyakdey.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class GroupAnagrams {

    private static final int[] PRIMES =
        {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
            97, 101};
    private static final int MOD = 1_000_000_007;
    private static final int SEED = 5381;

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            long hash = calcHash(str);
            if (!groups.containsKey(hash)) {
                groups.put(hash, new ArrayList<>());
            }
            groups.get(hash).add(str);
        }

        return groups.values().stream().toList();
    }

    private long calcHash(String str) {
        long hash = SEED;
        for (char ch : str.toCharArray()) {
            int index = ch - 97;
            hash = (hash * PRIMES[index]) % MOD;
        }

        return hash;
    }

}
