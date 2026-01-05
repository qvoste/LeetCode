package org.example.task_99;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int high = 0, low = 51, result = 0, sum = 0;
        int[] fq = new int[51];

        for(int a : apple) {
            sum += a;
        }

        for (int cap : capacity) {
            fq[cap]++;
            high = Math.max(high, cap);
            low = Math.min(low, cap);
        }

        for (int i = high; i >= low && sum > 0; i--) {
            while (fq[i]-- > 0 && sum > 0) {
                sum -= i;
                result++;
            }
        }
        return result;
    }
}
