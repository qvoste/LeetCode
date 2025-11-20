package org.example.task_42;

import java.util.Arrays;

class Solution {
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1])return b[0] - a[0];
            return a[1] - b[1];
        });

        int big = -1, prevBig = -1;

        int ans = 0;
        for(var cur: intervals) {
            int left = cur[0];
            int right = cur[1];

            if(big >= left && prevBig >= left) continue;

            if(big >= left) {
                prevBig = big;
                big = right;
                ans++;
            }else {
                big = right;
                prevBig = right - 1;
                ans += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{3,7},{8,9}};

        System.out.println(intersectionSizeTwo(intervals));
    }
}