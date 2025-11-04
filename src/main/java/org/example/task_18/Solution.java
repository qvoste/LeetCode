package org.example.task_18;

import java.util.*;

class Solution {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[51];
            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }
            List<int[]> cand = new ArrayList<>();
            for (int v = 1; v <= 50; v++) {
                if (freq[v] > 0) {
                    cand.add(new int[]{v, freq[v]});
                }
            }
            cand.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            });
            int sum = 0;
            int take = Math.min(x, cand.size());
            for (int t = 0; t < take; t++) {
                sum += cand.get(t)[0] * cand.get(t)[1];
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;
        System.out.println(Arrays.toString(findXSum(nums, k, x)));
    }
}