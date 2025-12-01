package org.example.task_64;

class Solution {
    public static long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = 0;

        for (int bat : batteries) {
            right += bat;
        }
        right /= n;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            long total = 0;
            for (int bat : batteries) {
                total += Math.min(bat, mid);
            }

            if (total >= mid * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3,3,3};

        System.out.println(maxRunTime(n, batteries));
    }
}