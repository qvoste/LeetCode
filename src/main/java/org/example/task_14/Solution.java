package org.example.task_14;

import java.util.Arrays;

class Solution {
    public static int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int[] result = new int[2];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] % n;
            nums[val] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 2 * n) {
                result[idx++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }
}