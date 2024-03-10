package com.priyakdey;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/encode-and-decode-strings/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class StringCodec {

    /**
     * Encodes a list of strings to a single string.
     *
     * @param strs {@link List<String>}
     * @return encoded string
     */
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";

        StringBuilder buffer = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            buffer.append(length);
            buffer.append("-");
            buffer.append(str);
        }

        return buffer.toString();
    }

    /**
     * Decodes a single string to a list of strings.
     *
     * @param s {@link String}
     * @return decoded list of strings
     */
    public List<String> decode(String s) {
        if (s == null) throw new IllegalArgumentException("invalid input");
        if (Objects.equals(s, "")) return List.of();

        System.out.println(s);

        int cursor = 0;
        int length = s.length();
        List<String> strs = new ArrayList<>();

        while (cursor < length) {
            char ch;
            int substrLen = 0;
            while (cursor < length && Character.isDigit(ch = s.charAt(cursor))) {
                substrLen = (substrLen * 10) + (ch - 48);
                cursor++;
            }

            if (cursor == length) throw new IllegalArgumentException("invalid input");

            // cursor points to "-" now, skip over to consume the word
            cursor++;
            int start = cursor;
            int end = cursor + substrLen;

            if (start == end) {
                strs.add("");
            }
            else {
                strs.add(s.substring(start, end));
            }

            cursor = end;
        }

        return strs;
    }

}
