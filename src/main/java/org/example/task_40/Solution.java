package org.example.task_40;

class Solution {
    public static int findFinalValue(int[] nums, int original) {
        while (true) {
            boolean zalupka = false;

            for (int num : nums) {
                if (num == original) {
                    original *= 2;
                    zalupka = true;
                    break;
                }
            }
            if (!zalupka) break;
        }
        return original;
    }

    public static void main(String[] args) {
        int[] nums = {8,19,4,2,15,3};
        int original = 2;

        System.out.println(findFinalValue(nums, original));
    }
}
