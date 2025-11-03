package org.example.task_17;

class Solution {
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            int sum = 0;
            int maxTime = 0;
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                sum += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            if (j - i > 1) {
                ans += sum - maxTime;
            }
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        System.out.println(minCost(colors, neededTime));
    }
}