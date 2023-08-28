package com.priyakdey.blind75;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.xml.transform.SourceLocator;

/**
 * @author Priyak Dey
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String hash = hash(str);
            if (groups.containsKey(hash)) {
                groups.get(hash).add(str);
            } else {
                groups.put(hash, new ArrayList<>(List.of(str)));
            }
        }

        return new ArrayList<>(groups.values());
    }

    /**
     * Helps generate the hash of the string.
     * hash(s) -> count of each char accumulated as a string
     * Note: This works for only ASCII charset(english lowercase alphabets only)
     *
     * @param s String
     * @return hash of the given string
     */
    private String hash(String s) {
        if (s.isEmpty()) return "0";

        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 97]++;
        }
        StringBuilder buffer = new StringBuilder();

        for (int count : charCount) {
            buffer.append("-");
            buffer.append(count);
        }

        return buffer.toString();
    }


}
