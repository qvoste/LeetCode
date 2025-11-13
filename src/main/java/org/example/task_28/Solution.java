package org.example.task_28;

class Solution {
    public static int maxOperations(String s) {
        int ans = 0;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ones++;
            } else {
                if (i == s.length() - 1 || s.charAt(i + 1) == '1') {
                    ans += ones;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }
}