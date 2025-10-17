package org.example.task_1;

class Solution {
    public String mergeAlternately(String word1, String word2) {

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (i < word1.length() && i < word2.length()){
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }

        if (i < word1.length()){
            result.append(word1.substring(i));
        }else if (i < word2.length()){
            result.append(word2.substring(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "abcd";
        String word2 = "1234567";
        String result = solution.mergeAlternately(word1, word2);
        System.out.println(result);
    }
}