package com.priyakdey.solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Boolean[][] cache = new Boolean[length + 1][length + 1];
        return wordBreak(s, 0, 1, new HashSet<>(wordDict), cache);
    }

    private boolean wordBreak(String s, int start, int end, Set<String> wordDict,
                              Boolean[][] cache) {
        if (end == s.length()) return wordDict.contains(s.substring(start));

        if (cache[start][end] != null) return cache[start][end];

        boolean canBreak = false;
        String substring = s.substring(start, end);
        if (wordDict.contains(substring)) {
            canBreak = canBreak || wordBreak(s, end , end + 1, wordDict, cache);
        }

        canBreak = canBreak || wordBreak(s, start , end + 1, wordDict, cache);
        cache[start][end] = canBreak;
        return canBreak;
    }
}
