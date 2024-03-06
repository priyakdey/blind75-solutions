package com.priyakdey.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        final Map<Character, Character> parenthesisPair =
            Map.of(')', '(', '}', '{', ']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!parenthesisPair.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(parenthesisPair.get(ch))) return false;
            }
        }

        return stack.isEmpty();
    }

}
