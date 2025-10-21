package org.example.task_4;

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2; // c запасом чтоб учесть возможные операции
        int[] count = new int[maxVal];

        for (int num : nums)
            count[num]++;

        for (int i = 1; i < maxVal; i++)
            count[i] += count[i - 1];

        int maxFrequency = 0;
        for (int i = 0; i < maxVal; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            maxFrequency = Math.max(maxFrequency, freq + Math.min(numOps, total - freq)); // строка заставившая плакать
        }
        return maxFrequency;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 70, 73};
        int k1 = 39;
        int numOps1 = 2;
        System.out.println(solution.maxFrequency(nums1, k1, numOps1));

        int[] nums2 = {1, 2, 4};
        int k2 = 5;
        int numOps2 = 1;
        System.out.println(solution.maxFrequency(nums2, k2, numOps2));

        int[] nums3 = {1, 4, 8, 13};
        int k3 = 5;
        int numOps3 = 2;
        System.out.println(solution.maxFrequency(nums3, k3, numOps3));
    }
}
