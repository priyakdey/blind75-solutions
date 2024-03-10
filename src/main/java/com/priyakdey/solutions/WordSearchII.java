package com.priyakdey.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class WordSearchII {

    // TODO: This is slow and performance needs to be looked into.

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length, cols = board[0].length;

        StringBuilder buffer = new StringBuilder();
        List<String> result = new ArrayList<>();
        Set<String> dict = Stream.of(words).collect(Collectors.toSet());

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                findWords(board, row, col, rows, cols, buffer, dict, result);
                buffer.setLength(0);
            }
        }

        return result;
    }

    private void findWords(char[][] board, int row, int col, int rows, int cols,
                           StringBuilder buffer, Set<String> dict, List<String> words) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == '#') return;

        char ch = board[row][col];
        buffer.append(ch);
        String word = buffer.toString();
        if (dict.contains(word)) {
            words.add(word);
            dict.remove(word);      // to avoid duplicate entries
        }

        board[row][col] = '#';

        findWords(board, row - 1, col, rows, cols, buffer, dict, words);
        findWords(board, row + 1, col, rows, cols, buffer, dict, words);
        findWords(board, row, col - 1, rows, cols, buffer, dict, words);
        findWords(board, row, col + 1, rows, cols, buffer, dict, words);

        buffer.deleteCharAt(buffer.length() - 1);
        board[row][col] = ch;
    }

}
