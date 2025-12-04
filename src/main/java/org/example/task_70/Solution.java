package org.example.task_70;

class Solution {
    public static int countCollisions(String s) {
        int n = s.length(), i = 0, j = n;
        char[] a = s.toCharArray();

        while (i < n && a[i] == 'L') i++;
        while (j > i && a[j - 1] == 'R') j--;

        int res = 0;
        while (i < j) if (a[i++] != 'S') res++;
        return res;
    }

    public static void main(String[] args) {
        String s = "RLRSLL";
        System.out.println(countCollisions(s));
    }
}