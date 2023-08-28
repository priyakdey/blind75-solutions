package com.priyakdey.blind75;

import java.util.Map;
import java.util.Stack;

/**
 * @author Priyak Dey
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> bracketPair = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> stack = new Stack<>();

        boolean isValid = true;

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracketPair.containsKey(bracket)) {
                if (stack.isEmpty() || stack.pop() != bracketPair.get(bracket)) {
                    isValid = false;
                    break;
                }
            } else {
                stack.push(bracket);
            }
        }

        return isValid && stack.isEmpty();
    }
}

