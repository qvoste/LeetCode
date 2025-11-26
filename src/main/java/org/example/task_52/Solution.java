package org.example.task_52;

class Solution {
    public static int smallestRepunitDivByK(int k) {
        long r = 0;
        for (int i = 1; i <= k; ++i) {
            r = (r * 10 + 1) % k;
            if (r == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int k = 3;
        System.out.println(smallestRepunitDivByK(k));
    }
}