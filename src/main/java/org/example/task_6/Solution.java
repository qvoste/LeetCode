package org.example.task_6;

class Solution {
    public static boolean hasSameDigits(String s) { // static чтоб обьекты в тесте не плодить
        // чтоб менять на ходу
        char[] digits = s.toCharArray();
        int currentLength = digits.length;

        while (currentLength > 2) {
            for (int i = 0; i < currentLength - 1; i++) {
                int current  = digits[i]     - '0';
                int next = digits[i + 1] - '0';
                int sum = (current + next) % 10;
                digits[i] = (char)(sum + '0');
            }
            currentLength--;
        }
        return digits[0] == digits[1];
    }

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
    }
}