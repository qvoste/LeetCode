package org.example.task_57;

class Solution {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                // слева ниже или равно — можно считать воду здесь
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                // справа ниже — считаем там
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] heigth = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heigth));
    }
}