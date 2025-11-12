package org.example.task_26;

class Solution {
    public static int minOperations(int[] nums) {
        int numsLength = nums.length;
        int countOnes = 0;
        int minLen = Integer.MAX_VALUE;

        for (int num : nums) if (num == 1) countOnes++;
        if (countOnes > 0) return numsLength - countOnes;

        // самый короткий подмассив, где gcd равен 1
        for (int i = 0; i < numsLength; i++) {
            int currentGcd = nums[i];
            for (int j = i + 1; j < numsLength; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) return -1;
        return (minLen - 1) + (numsLength - 1);
    }

    //gcd - greatest common divisor(наибольший общий делитель)
    //находится по алгоритму Евклида
    private static int gcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int remainder = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = remainder;
        }
        return firstNumber;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,3,4};
        System.out.println(minOperations(nums));
    }
}