package org.example.task_32;

class Solution {
    public static int numberOfSubstrings(String s) {
        int sLength = s.length();
        int[] prevZero = new int[sLength + 1]; // Cсылка на предыдущий ноль
        prevZero[0] = -1;
        for (int i = 0; i < sLength; i++) {
            if (i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                prevZero[i + 1] = i;
            } else {
                prevZero[i + 1] = prevZero[i];
            }
        }
        int res = 0;
        for (int i = 1; i <= sLength; i++) {
            int countZero = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;
            while (j > 0 && countZero * countZero <= sLength) {
                int countOne = (i - prevZero[j]) - countZero;
                if (countZero * countZero <= countOne) {
                    res += Math.min(j - prevZero[j], countOne - countZero * countZero + 1);
                }
                j = prevZero[j];
                countZero++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "00011";
        System.out.println(numberOfSubstrings(s));
    }
}