package org.example.task_58;

import java.util.*;

class Solution {
    public int comp = 0;

    private long dfs(int node, int parent, List<List<Integer>> adj, int[] values, int k) {
        long total = values[node];
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                total += dfs(neighbor, node, adj, values, k);
            }
        }

        if (total % k == 0) {
            comp += 1;
            return 0;
        }
        return total % k;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>(n);
        comp = 0;

        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, adj, values, k);
        return comp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edges = {{0,2},{1,2},{1,3},{2,4}};
        int[] values = {1,8,1,4,4};
        int k = 6;

        System.out.println(solution.maxKDivisibleComponents(n, edges, values, k));

    }
}