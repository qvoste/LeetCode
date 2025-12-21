package org.example.task_92;

class Solution {
    public static long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        int kk = k / 2, n = prices.length;
        long current = 0, max = 0;
        for(int i = 0; i < kk; i++) {
            int val = prices[i] * strategy[i];
            sum += val;
            current += prices[i] - val;
        }
        for(int i = kk; i < k; i++) {
            int val = prices[i] * strategy[i];
            sum += val;
            current += prices[i] - val - prices[i - kk];
        }
        max = Math.max(max, current);
        for(int i = k; i < n; i++) {
            int val = prices[i] * strategy[i];
            sum += val;
            current += prices[i] - val - prices[i - kk] + prices[i - k] * strategy[i - k];
            max = Math.max(max, current);
        }
        return sum + max;
    }

    public static void main(String[] args) {
        int[] prices = {4, 2, 8};
        int[] strategy = {-1, 0, 1};
        int k = 2;
        System.out.println(maxProfit(prices, strategy, k));
    }
}
