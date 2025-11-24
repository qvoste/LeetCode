package org.example.task_50;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int current = 0;

        for (int num : nums) {
            current = ((current << 1) + num) % 5;
            res.add(current == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        System.out.println(prefixesDivBy5(nums));
    }
}
