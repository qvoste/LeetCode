package org.example.task_63;

class Solution {
    public static int lengthOfLastWord(String s) {
        int result = 0;
        int i = s.length() - 1;

        while(i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0 && s.charAt(i) != ' ') {
            i--;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}