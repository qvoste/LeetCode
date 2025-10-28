package org.example.task_11;

class Solution {
    public int countValidSelections(int[] nums) {
        int length = nums.length;
        int ans = 0, sum = 0, left = 0, right;

        for (int num : nums) {
            sum += num;
        }

        right = sum;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (left - right >= 0 && left - right <= 1) {
                    ans++;
                }
                if (right - left >= 0 && right - left <= 1) {
                    ans++;
                }
            } else {
                left += nums[i];
                right -= nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,0,2,0,3};
        System.out.println(solution.countValidSelections(nums1)); // 2

        int[] nums2 = {2,3,4,0,4,1,0};
        System.out.println(solution.countValidSelections(nums2)); // 0
    }
}