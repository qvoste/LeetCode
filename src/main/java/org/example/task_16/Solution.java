package org.example.task_16;

//код длинноватый и не самый быстрый, но зато самый понятный
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int totalGuards = guards.length;
        int totalWalls = walls.length;
        int guardedCells = 0;

        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        for (int[] g : guards) {
            int r = g[0], c = g[1];

            for (int i = r + 1; i < m && grid[i][c] != 2; i++) {
                if (grid[i][c] == 0) {
                    grid[i][c] = 1;
                    guardedCells++;
                }
            }

            for (int i = r - 1; i >= 0 && grid[i][c] != 2; i--) {
                if (grid[i][c] == 0) {
                    grid[i][c] = 1;
                    guardedCells++;
                }
            }

            for (int j = c + 1; j < n && grid[r][j] != 2; j++) {
                if (grid[r][j] == 0) {
                    grid[r][j] = 1;
                    guardedCells++;
                }
            }

            for (int j = c - 1; j >= 0 && grid[r][j] != 2; j--) {
                if (grid[r][j] == 0) {
                    grid[r][j] = 1;
                    guardedCells++;
                }
            }
        }

        int unguarded = (m * n) - (totalGuards + totalWalls + guardedCells);
        return unguarded;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};

        Solution sol = new Solution();
        int result = sol.countUnguarded(m, n, guards, walls);
        System.out.println(result);
    }
}