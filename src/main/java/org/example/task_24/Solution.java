package org.example.task_24;

import java.util.*;

class Solution {
    public static int minOperations(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int minOps = 0;

        for (int currentNum : nums) {
            while (!stk.isEmpty() && stk.peekLast() > currentNum) {
                stk.pollLast();
            }
            if (currentNum == 0) continue;
            if (stk.isEmpty() || stk.peekLast() < currentNum) {
                minOps++;
                stk.addLast(currentNum);
            }
        }
        return minOps;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2};
        System.out.println(minOperations(nums));
    }
}