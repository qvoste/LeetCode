package org.example.task_8;

class Solution {
    public static int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int weekSum = weeks * (49 + 7 * weeks) / 2;
        int daySum = days * (2 * weeks + days + 1) / 2;
        return weekSum + daySum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(totalMoney(n)); // 96
    }
}