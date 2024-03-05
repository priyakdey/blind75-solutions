package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class WordDictionary {

    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        if (word.isEmpty()) return;

        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 97;
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int cursor) {
        while (cursor < word.length()) {
            char ch = word.charAt(cursor);
            if (ch == '.') {
                boolean isMatch = false;
                for (Node child : node.children) {
                    if (child != null) {
                        isMatch = isMatch || search(child, word, cursor + 1);
                    }
                }
                return isMatch;
            } else {
                int index = ch - 97;
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            cursor++;
        }

        return node.isWord;
    }

    private static final class Node {
        private final Node[] children;
        private boolean isWord;

        private Node() {
            this.children = new Node[26];
        }
    }

}
