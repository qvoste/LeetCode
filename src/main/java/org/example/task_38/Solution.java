package org.example.task_38;

class Solution {
    public static boolean isOneBitCharacter(int[] bits) {
        final int length = bits.length;
        int i = 0;

        while(i < length - 1){
            i += 1 + bits[i];
        }
        return i == length - 1;
    }

    public static void main(String[] args) {
        int[] bits = {1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}