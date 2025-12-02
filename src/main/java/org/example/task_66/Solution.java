package org.example.task_66;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static final int MOD = 1_000_000_007;

    public static int countTrapezoids(int[][] points) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            freq.merge(p[1], 1, Integer::sum);
        }

        long prev = 0;
        long total = 0;

        for (int count : freq.values()) {
            if (count < 2) continue;
            long pairs = count * (count - 1L) / 2;
            total = (total + prev * pairs) % MOD;
            prev = (prev + pairs) % MOD;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        int[][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};
        System.out.println(countTrapezoids(points));
    }
}