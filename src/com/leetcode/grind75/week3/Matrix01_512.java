package com.leetcode.grind75.week3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Matrix01_512 {

    // TODO: look for a faster one
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        int max = Math.max(mat.length, mat[0].length);
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(result[i], max);
        }
        boolean isChanged;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        do {
            isChanged = false;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int fastestPath = getSmallestNeighbour(result, i, j, max) + 1;
                    if (result[i][j] > fastestPath) {
                        result[i][j] = fastestPath;
                        isChanged = true;
                    }
                }
            }
        } while (isChanged);

        return result;
    }

    private int getSmallestNeighbour(int[][] matrix, int i, int j, int max) {
        int min = max;
        if (i - 1 >= 0) {
            min = Math.min(min, matrix[i - 1][j]);
        }
        if (j - 1 >= 0) {
            min = Math.min(min, matrix[i][j - 1]);
        }
        if (j + 1 < matrix[0].length) {
            min = Math.min(min, matrix[i][j + 1]);
        }
        if (i + 1 < matrix.length) {
            min = Math.min(min, matrix[i + 1][j]);
        }
        return min;
    }

    @Test
    public void test() {
        assertTrue(Arrays.deepEquals(new int[][]{{0}}, updateMatrix(new int[][]{{0}})));
        assertTrue(Arrays.deepEquals(new int[][]{{0, 1}}, updateMatrix(new int[][]{{0, 1}})));
    }
}
