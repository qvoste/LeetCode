package org.example.task_93;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }
    public void transpose(int[][]arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    public void reverseRow(int[][]arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            int start=0,end=len-1;
            while(start<end){
                int temp=arr[i][start];
                arr[i][start++]=arr[i][end];
                arr[i][end--]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
