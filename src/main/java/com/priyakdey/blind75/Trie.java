package com.priyakdey.blind75;

/**
 * @author Priyak Dey
 */
public class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            // @NOTE: This is a special case where "" is a valid word in the dictionary. Depends on use case.
            root.isWord = true;
            return;
        }

        char[] chars = word.toCharArray();
        Node curr = this.root;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = characterToIndex(ch);
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return this.root.isWord;    // @NOTE: special case when dictionary has "" as a valid word
        }

        char[] chars = word.toCharArray();
        Node curr = this.root;
        boolean wordFound = true;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = characterToIndex(ch);
            Node node = curr.children[index];
            if (node == null) {
                wordFound = false;
                break;
            }
            curr = node;
        }

        return wordFound && curr.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node curr = this.root;
        boolean prefixFound = true;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int index = characterToIndex(ch);
            Node node = curr.children[index];
            if (node == null) {
                prefixFound = false;
                break;
            }
            curr = node;
        }

        return prefixFound;
    }

    private int characterToIndex(char ch) {
        return (int) ch - 97;
    }


    static class Node {
        Node[] children;
        boolean isWord;

        Node() {
            this.children = new Node[26];
            isWord = false;
        }

    }

}
