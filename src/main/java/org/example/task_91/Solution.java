package org.example.task_91;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int topRow = 0;
        int rightColumn = matrix[0].length - 1;
        int bottomRow = matrix.length - 1;
        int leftColumn = 0;

        while (topRow <= bottomRow && rightColumn >= leftColumn) {
            for (int i = leftColumn; i <= rightColumn ; i++) {
                ans.add(matrix[topRow][i]);
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                ans.add(matrix[i][rightColumn]);
            }
            rightColumn--;

            if(topRow <= bottomRow){
                for (int i = rightColumn; i >= leftColumn; i--) {
                    ans.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }

            if(leftColumn <= rightColumn){
                for (int i = bottomRow; i >= topRow; i--) {
                    ans.add(matrix[i][leftColumn]);
                }
                leftColumn++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}