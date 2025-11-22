package org.example.task_46;

class Solution {
    public static int minimumOperations(int[] nums) {
        int result = 0;
        for(int num : nums) if(num % 3 != 0) result++; return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(minimumOperations(nums));
    }
}
