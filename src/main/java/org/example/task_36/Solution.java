package org.example.task_36;

class Solution {
    public static boolean kLengthApart(int[] nums, int k) {
        int prev = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(prev != -1 && i - prev < k + 1){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k = 2;

        System.out.println(kLengthApart(nums, k));
    }
}