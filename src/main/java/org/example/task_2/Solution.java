package org.example.task_2;

class Solution {

    int result = 0;

    public int differenceOfSums(int n, int m) {
        for (int i = 1; i <= n; i++){
            if ((i % m) != 0){
                result = result + i;
            } else {
                result = result - i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int m = 3;
        String result = String.valueOf(solution.differenceOfSums(n, m));
        System.out.println(result);
    }
}