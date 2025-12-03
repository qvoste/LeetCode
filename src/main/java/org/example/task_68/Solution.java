package org.example.task_68;

import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double inf = 1e9 + 7;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double slope;
                double intercept;

                if (x2 == x1) {
                    slope = inf;
                    intercept = x1;
                } else {
                    slope = (1.0 * (y2 - y1)) / (x2 - x1);
                    intercept = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }

                if (slope == -0.0) slope = 0.0;
                if (intercept == -0.0) intercept = 0.0;

                int mid = (x1 + x2) * 10000 + (y1 + y2);

                slopeToIntercept
                        .computeIfAbsent(slope, k -> new ArrayList<>())
                        .add(intercept);
                midToSlope
                        .computeIfAbsent(mid, k -> new ArrayList<>())
                        .add(slope);
            }
        }

        for (List<Double> list : slopeToIntercept.values()) {
            if (list.size() < 2) continue;

            Map<Double, Integer> count = new TreeMap<>();
            for (double b : list) {
                count.put(b, count.getOrDefault(b, 0) + 1);
            }

            int total = 0;
            for (int freq : count.values()) {
                result += total * freq;
                total += freq;
            }
        }

        for (List<Double> list : midToSlope.values()) {
            if (list.size() < 2) continue;

            Map<Double, Integer> count = new TreeMap<>();
            for (double s : list) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }

            int total = 0;
            for (int freq : count.values()) {
                result -= total * freq;
                total += freq;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{-3,2},{3,0},{2,3},{3,2},{2,-3}};
        Solution solution = new Solution();

        System.out.println(solution.countTrapezoids(points));
    }
}