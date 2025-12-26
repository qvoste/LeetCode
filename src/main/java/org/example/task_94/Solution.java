package org.example.task_94;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        parent[firstPerson] = 0; // человек 0 — источник секрета

        // Группируем встречи по времени (максимальное время ≤ 10^5)
        List<int[]>[] meetingsByTime = new List[100001];
        for (int[] m : meetings) {
            int t = m[2];
            if (meetingsByTime[t] == null) {
                meetingsByTime[t] = new ArrayList<>();
            }
            meetingsByTime[t].add(new int[]{m[0], m[1]});
        }

        // Обрабатываем встречи по возрастанию времени
        for (int time = 0; time < meetingsByTime.length; time++) {
            if (meetingsByTime[time] == null) continue;

            List<int[]> currentMeetings = meetingsByTime[time];

            // 1. Объединяем всех участников текущего времени
            for (int[] meet : currentMeetings) {
                union(meet[0], meet[1], parent);
            }

            // 2. Если группа не связана с человеком 0 — "забываем" объединения
            for (int[] meet : currentMeetings) {
                int a = meet[0], b = meet[1];
                if (find(a, parent) != 0) {
                    parent[a] = a;
                }
                if (find(b, parent) != 0) {
                    parent[b] = b;
                }
            }
        }

        // Собираем всех, кто знает секрет (корень = 0)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == 0) {
                result.add(i);
            }
        }
        return result;
    }

    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py) {
            if (px < py) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
        }
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); // теперь создаём объект

        int n = 6;
        int[][] meetings = {{1,2,5}, {2,3,8}, {1,5,10}};
        int firstPerson = 1;

        List<Integer> result = solution.findAllPeople(n, meetings, firstPerson);
        System.out.println(result); // Ожидаемый вывод: [0, 1, 2, 3, 5]
    }
}