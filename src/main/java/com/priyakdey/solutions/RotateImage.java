package com.priyakdey.solutions;

/**
 * <a href="https://leetcode.com/problems/rotate-image/description/">Problem Statement</a>
 *
 * @author Priyak Dey
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        transpose(matrix);

        // reverse each row
        for (int i = 0; i < length; i++) {
            int left = 0, right = length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    private void transpose(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
