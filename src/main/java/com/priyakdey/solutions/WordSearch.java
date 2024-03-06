package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/word-search/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int rows = board.length, cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exist(board, row, col, rows, cols, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int row, int col, int rows, int cols, String word,
                          int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;

        char ch = board[row][col];
        if (ch != word.charAt(index)) return false;

        board[row][col] = '#';

        boolean matches =
                exist(board, row + 1, col, rows, cols, word, index + 1) ||
                exist(board, row - 1, col, rows, cols, word, index + 1) ||
                exist(board, row, col + 1, rows, cols, word, index + 1) ||
                exist(board, row, col - 1, rows, cols, word, index + 1);

        board[row][col] = ch;
        return matches;
    }
}
