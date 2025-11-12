package org.example.task_27;

import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = m - 1;
        int point2 = n - 1;
        int point = m + n - 1;

        while (point2 >= 0) {
            if (point1 >= 0 && nums1[point1] > nums2[point2]) {
                nums1[point--] = nums1[point1--];
            } else {
                nums1[point--] = nums2[point2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0}, num2 = {2,5,6};
        int m = 3,n = 3;
        merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}