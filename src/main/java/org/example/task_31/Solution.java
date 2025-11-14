package org.example.task_31;

class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int uniquePos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniquePos] = nums[i];
                uniquePos++;
            }
        }
        return uniquePos;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(removeDuplicates(nums));
    }
}