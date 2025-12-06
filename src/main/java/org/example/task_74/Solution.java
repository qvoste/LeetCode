package org.example.task_74;

class Solution {
    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long prefixSum = 1;
        int left = 0;

        java.util.Deque<Integer> maxQ = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> minQ = new java.util.ArrayDeque<>();

        for (int right = 0; right < n; ++right) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[right]) {
                maxQ.pollLast();
            }
            maxQ.addLast(right);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[right]) {
                minQ.pollLast();
            }
            minQ.addLast(right);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                if (minQ.peekFirst() == left) minQ.pollFirst();

                prefixSum = (prefixSum - dp[left] + MOD) % MOD;
                left++;
            }
            dp[right + 1] = prefixSum;
            prefixSum = (prefixSum + dp[right + 1]) % MOD;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,3,7};
        int k = 4;

        System.out.println(countPartitions(nums, k));
    }
}