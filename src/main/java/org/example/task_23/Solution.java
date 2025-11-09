package org.example.task_23;

class Solution {
    public static int countOperations(int num1, int num2) {
        int i = 0;
        while(num1 != 0 & num2 != 0){
            if (num1 >= num2){
                num1 = num1 - num2;
            } else num2 = num2 - num1;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;
        System.out.println(countOperations(num1, num2));
    }
}