package org.example.task_47;

class Solution {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];

        for (int c : citations) {
            if (c >= n) bucket[n]++;
            else bucket[c]++;
        }

        int sum = 0;
        for (int h = n; h >= 0; h--) {
            sum += bucket[h];
            if (sum >= h) return h;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(hIndex(citations));
    }
}