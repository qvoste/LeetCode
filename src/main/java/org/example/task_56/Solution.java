package org.example.task_56;

class Solution {
    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long ans = Long.MIN_VALUE;
        long[] minPrefixByMod = new long[k];
        java.util.Arrays.fill(minPrefixByMod, Long.MAX_VALUE / 2);
        minPrefixByMod[0] = 0;

        for (int i = 1; i <= n; i++) {
            int mod = i % k;

            if (minPrefixByMod[mod] != Long.MAX_VALUE / 2) {
                long currentSum = prefix[i] - minPrefixByMod[mod];
                ans = Math.max(ans, currentSum);

            }
            minPrefixByMod[mod] = Math.min(minPrefixByMod[mod], prefix[i]);
        }

        if (ans == Long.MIN_VALUE) {
            return prefix[n];

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;

        System.out.println(maxSubarraySum(nums, k));
    }
}