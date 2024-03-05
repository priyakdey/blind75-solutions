package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class Trie {

    private final Node root;
    private int totalWords;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
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
        totalWords++;
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        Node node = traverse(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return totalWords != 0;
        Node node = traverse(prefix);
        return node != null;
    }

    private Node traverse(String word) {
        Node curr = root;
        for (int i = 0, length = word.length(); i < length && curr != null; i++) {
            char ch = word.charAt(i);
            int index = ch - 97;
            curr = curr.children[index];
        }

        return curr;
    }

    private static class Node {
        private final Node[] children;
        private boolean isWord;

        private Node() {
            children = new Node[26];
        }
    }

}
