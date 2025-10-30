package org.example.task_13;

//хз поч хард, задача буквально на 15 минут
class Solution {
    public static int minNumberOperations(int[] target) {
        int n = target.length;
        int ops = target[0];

        for (int i = 1; i < n; i++) {
            if (target[i] > target[i - 1]) {
                ops += target[i] - target[i - 1];
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        int[] target = {3,1,1,2};
        System.out.println(minNumberOperations(target));
    }
}