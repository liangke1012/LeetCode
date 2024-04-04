package leetcode.graph;

import java.util.*;

public class GetAncestors {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        List<List<Integer>> res = new ArrayList<>();
        res = getAncestors(n, edges);
        
    }

    private static List<List<Integer>> getAncestors(int n, int[][] edges) {
        Set<Integer>[] anc = new Set[n];
        for (int i = 0; i < n; i++) {
            anc[i] = new HashSet<Integer>();
        }

        List<Integer>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<Integer>();
        }
        int[] in = new int[n];
        for(int[] edge : edges){
            e[edge[0]].add(edge[1]);
            ++in[edge[1]];
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : e[u]) {
                anc[v].add(u);
                for (int i : anc[u]){
                    anc[v].add(i);
                }
                --in[v];
                if(in[v] == 0) {
                    q.offer(v);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            for (int j : anc[i]){
                res.get(i).add(j);
            }
            Collections.sort(res.get(i));
        }
        return res;
    }
}
