package org.example.task_34;

class Solution {
    public static int numSub(String s) {
        final int mod = 1000000007;
        long res = 0;
        int count = 0;
        for (char num : s.toCharArray()) {
            if (num == '1') {
                count++;
            } else {
                if (count > 0) {
                    res = (res + (long) count * (count + 1) / 2) % mod;
                    count = 0;
                }
            }
        }
        if (count > 0) {
            res = (res + (long) count * (count + 1) / 2) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        String s = "0110111";

        System.out.println(numSub(s));
    }
}