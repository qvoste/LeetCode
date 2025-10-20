package org.example.task_3;

//только после того как написал додумался что можно найти содержится ли "+", если да x++ иначе x--. мои пальцы оказались быстрее умных мыслей...

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            switch (operation) {
                case "X++":
                case "++X":
                    x++;
                    break;
                case "X--":
                case "--X":
                    x--;
                    break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = {"X++","++X","--X","X--"};
        int result = new Solution().finalValueAfterOperations(operations);
        System.out.println(result);
    }
}

