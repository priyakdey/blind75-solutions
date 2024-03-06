package com.priyakdey.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int rows = grid.length, cols = grid[0].length;

        int islandCount = 0;
        Deque<Cell> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '0') continue;

                islandCount++;
                grid[row][col] = '0';
                queue.offer(new Cell(row, col));

                while (!queue.isEmpty()) {
                    Cell cell = queue.poll();
                    int r = cell.row;
                    int c = cell.cell;

                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        grid[r - 1][c] = '0';
                        queue.offer(new Cell(r - 1, c));
                    }
                    if (r + 1 < rows && grid[r + 1][c] == '1') {
                        grid[r + 1][c] = '0';
                        queue.offer(new Cell(r + 1, c));
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        grid[r][c - 1] = '0';
                        queue.offer(new Cell(r, c - 1));
                    }
                    if (c + 1 < cols && grid[r][c + 1] == '1') {
                        grid[r][c + 1] = '0';
                        queue.offer(new Cell(r, c + 1));
                    }
                }
            }
        }

        return islandCount;
    }


    private record Cell(int row, int cell) {
    }

}
