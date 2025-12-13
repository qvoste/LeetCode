package org.example.task_83;

import java.util.Arrays;

class Solution {
    public static int countCoveredBuildings(int n, int[][] buildings) {

        int[] rowMax = new int[n + 1];
        int[] rowMin = new int[n + 1];
        int[] columnMax = new int[n + 1];
        int[] columnMin = new int[n + 1];

        Arrays.fill(rowMin, n + 1);
        Arrays.fill(columnMin, n + 1);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowMax[y] = Math.max(rowMax[y], x);
            rowMin[y] = Math.min(rowMin[y], x);

            columnMax[x] = Math.max(columnMax[x], y);
            columnMin[x] = Math.min(columnMin[x], y);
        }

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if (x > rowMin[y] && x < rowMax[y] &&
                    y > columnMin[x] && y < columnMax[x]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        System.out.println(countCoveredBuildings(n, buildings));
    }
}