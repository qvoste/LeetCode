package org.example.task_69;

class Solution {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length(), i, j=0, gap = 0, a = numRows*2 - 2;
        StringBuilder ans = new StringBuilder();

        while(a > -1) {
            i = j++;
            if(i < n) ans.append(s.charAt(i));
            while(i < n) {
                i += a;
                if(i < n) {
                    if(a != 0) {
                        ans.append(s.charAt(i));
                    }
                }
                else break;
                i += gap;
                if(i < n && gap != 0) ans.append(s.charAt(i));
            }
            a -= 2;
            gap += 2;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));
    }
}