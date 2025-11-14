package org.example.task_30;

import java.util.Arrays;

class Solution {
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        // Задаём размер n+1, чтоб не выйти из границ, как твой отец из семьи
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int row1 = q[0], col1 = q[1], row2 = q[2], col2 = q[3];
            diff[row1][col1] += 1;
            if (col2 + 1 < n) diff[row1][col2 + 1] -= 1;
            if (row2 + 1 < n) diff[row2 + 1][col1] -= 1;
            if (row2 + 1 < n && col2 + 1 < n) diff[row2 + 1][col2 + 1] += 1;
        }

        int[][] mat = new int[n][n];

        mat[0][0] = diff[0][0];
        for (int j = 1; j < n; j++) {
            mat[0][j] = mat[0][j - 1] + diff[0][j];
        }
        for (int i = 1; i < n; i++) {
            mat[i][0] = mat[i - 1][0] + diff[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1] + diff[i][j];
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{1,1,2,2}, {0,0,1,1}};

        System.out.println(Arrays.deepToString(rangeAddQueries(n, queries)));
    }
}