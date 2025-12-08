package org.example.task_78;

class Solution {
    public static int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int cSquared = a * a + b * b;
                int c = (int) Math.sqrt(cSquared);

                if (c <= n && c * c == cSquared) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countTriples(n));
    }
}