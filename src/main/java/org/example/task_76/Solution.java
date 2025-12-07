package org.example.task_76;

class Solution {
    public static int countOdds(int low, int high) {
        int result = (high - low) / 2;
        if (low % 2 != 0 || high % 2 != 0) result += 1;
        return result;
    }

    public static void main(String[] args) {
        int low = 3,high = 7;
        System.out.println(countOdds(low, high));
    }
}