package com.priyakdey.blind75;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class AddAndSearchWord {

    private final Node root;

    public AddAndSearchWord() {
        root = new Node();
    }

    public void addWord(String word) {
        if (word.isEmpty()) {
            // @ NOTE: special case where "" is a valid word in our dictionary. If not, we can just return without setting this flag.
            root.isWord = true;
            return;
        }

        char[] chars = word.toCharArray();
        Node curr = root;

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
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] charArray, int index, Node node) {
        char ch = charArray[index];

        boolean anyMatch = false;

        if (index == charArray.length - 1) {
            // this is the last char of the word
            if (ch != '.') {
                // node should have the same child as the letter, and it should be a word ending
                int idx = characterToIndex(ch);
                Node child = node.children[idx];
                return child != null && child.isWord;
            } else {
                return Arrays.stream(node.children)
                    .anyMatch(_node -> _node != null && _node.isWord);
            }
        }

        if (ch != '.') {
            // match the exact key and move forward
            int idx = characterToIndex(ch);
            Node child = node.children[idx];
            if (child != null) {
                anyMatch = search(charArray, index + 1, child);
            }
        } else {
            // find all the keys and try for all possible children
            List<Node> children = Arrays.stream(node.children).filter(Objects::nonNull).toList();
            for (Node child : children) {
                if (search(charArray, index + 1, child)) {
                    anyMatch = true;
                    break;
                }
            }
        }

        return anyMatch;

    }


    private int characterToIndex(char ch) {
        return (int) ch - 97;
    }


    static class Node {
        Node[] children;
        boolean isWord;

        Node() {
            this.children = new Node[26];
            this.isWord = false;
        }

    }


    // TESTING
    public static void main(String[] args) {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");

//        System.out.println(addAndSearchWord.search("pad"));
//        System.out.println(addAndSearchWord.search("bad"));
//        System.out.println(addAndSearchWord.search("...d"));
//        System.out.println(addAndSearchWord.search("b.."));
//        System.out.println(addAndSearchWord.search(".a."));
//        System.out.println(addAndSearchWord.search("b.d"));
//        System.out.println(addAndSearchWord.search("b.d."));
//        System.out.println(addAndSearchWord.search("b..."));
//        System.out.println(addAndSearchWord.search("ba."));
        System.out.println(addAndSearchWord.search("b.."));
//        System.out.println(addAndSearchWord.search("..."));
//        System.out.println(addAndSearchWord.search(".."));
    }

}
