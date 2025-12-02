package org.example.task_67;

public class Solution {
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());

        int i = arr.length - 1;

        while (i >= 0) {
            if (arr[i] == ' ') { i--; continue; }

            int j = i;
            while (i >= 0 && arr[i] != ' ') i--;
            int start = i + 1;

            if (sb.length() > 0) sb.append(' ');
            sb.append(arr, start, j - start + 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}