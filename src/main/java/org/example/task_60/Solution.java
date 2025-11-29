package org.example.task_60;

class Solution {
    public static int minOperations(int[] nums, int k) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        long mod = sum % k;
        if (mod < 0) mod += k;

        return (int) mod;
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 7};
        int k = 5;

        System.out.println(minOperations(nums, k));
    }
}