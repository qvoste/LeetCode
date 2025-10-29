package org.example.task_12;

public class Solution {
    public static int smallestNumber(int n) {
        while ((n & (n + 1)) != 0){
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(smallestNumber(a));
    }
}
