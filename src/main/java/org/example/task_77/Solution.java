package org.example.task_77;

class Solution {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, n = s.length(), m = t.length();

        for (int j = 0; j < m && i < n; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}