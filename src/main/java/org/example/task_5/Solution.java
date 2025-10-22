package org.example.task_5;

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;

        int leftClose = 0; // левая граница [num - k, num + k]
        int rightClose = 0; // правая граница [num - k, num + k]
        int countInCloseWindow = 0; // сколько чисел [num-k, num+k]

        int leftFar = 0; // левая граница [num - 2*k, num + 2*k]
        int countInFarWindow = 0; // сколько чисел [num-2k, num+2k]

        int currentFreq = 0; // сколько раз встречается число
        int prevNum = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // Подсчёт частоты
            if (num == prevNum) {
                currentFreq++;
            } else {
                prevNum = num;
                currentFreq = 1;
            }

            // Сдвигаем leftClose
            while (nums[leftClose] < num - k) {
                countInCloseWindow--;
                leftClose++;
            }

            // Расширяем rightClose
            while (rightClose < n && nums[rightClose] <= num + k) {
                countInCloseWindow++;
                rightClose++;
            }

            int canPromoteFromClose = countInCloseWindow - currentFreq;
            int withClosePromotions = currentFreq + Math.min(canPromoteFromClose, numOperations);
            result = Math.max(result, withClosePromotions);

            // [num - 2*k, num + 2*k]
            countInFarWindow++;
            while (nums[leftFar] < num - 2L * k) {
                countInFarWindow--;
                leftFar++;
            }
            result = Math.max(result, Math.min(countInFarWindow, numOperations));
        }
        return result;
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