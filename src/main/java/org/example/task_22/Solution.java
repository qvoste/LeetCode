package org.example.task_22;

class Solution {
    public static int minimumOneBitOperations(int n) {
        int res = n;
        while (n > 0) {
            n >>= 1;
            res ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(minimumOneBitOperations(n));
    }
}