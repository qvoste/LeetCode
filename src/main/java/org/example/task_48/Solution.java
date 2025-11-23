package org.example.task_48;

//dp варик не оптимальный, но я до этого решал только через Greedy, так-что надо б для разнообразия
class Solution {
    public static int maxSumDivThree(int[] nums) {
        int dp[] = new int[3];

        for(int num : nums) {
            int next[] = dp.clone();
            for(int curr : dp) {
                int sum = curr + num;
                int index = sum%3;
                next[index] = Math.max(next[index], sum);
            }
            dp = next;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        System.out.println(maxSumDivThree(nums));
    }
}