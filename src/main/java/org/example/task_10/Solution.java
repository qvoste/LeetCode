package org.example.task_10;

class Solution {
    public int numberOfBeams(String[] bank) {
        int laserBeams = 0;
        int prevOnes = 0;
        for (String row : bank) {
            int currentOnes = 0;
            for (char c : row.toCharArray()) {
                currentOnes += c & 1; // не люблю побитово, но так быстрее
            }
            if (currentOnes > 0) {
                laserBeams += prevOnes * currentOnes;
                prevOnes = currentOnes;
            }
        }
        return laserBeams;
    }
}