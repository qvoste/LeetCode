package org.example.task_21;

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long min = 0, max = 0;
        for (int station : stations) max += station;
        max += k;

        long ans = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (canAchieve(stations, r, k, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(int[] stations, int r, long k, long target) {
        long used = 0, windowSum = 0;
        int n = stations.length;
        long[] add = new long[n];

        for (int i = 0; i <= r && i < n; i++) {
            windowSum += stations[i];
        }

        for (int i = 0; i < n; i++) {
            if (i - r - 1 >= 0) windowSum -= stations[i - r - 1] + add[i - r - 1];
            if (i + r < n && i != 0) windowSum += stations[i + r] + add[i + r];

            if (windowSum < target) {
                long need = target - windowSum;
                if (used + need > k) return false;
                used += need;
                add[Math.min(n - 1, i + r)] += need;
                windowSum += need;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stations = {1,2,4,5,0};
        int r = 1;
        int k = 2;
        System.out.println(solution.maxPower(stations, r, k));
    }
}
