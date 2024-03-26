package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。

请你实现一个 Graph 类：

Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
**/
public class Graph2642 {
    private List<int []>[] graph;
    public Graph2642(int n, int[][] edges) {
        graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<int[]>();
        }
        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            int cost = e[2];
            graph[x].add(new int[]{y, cost});
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0];
        int y = edge[1];
        int cost = edge[2];
        graph[x].add(new int[]{y, cost});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        pq.offer(new int[]{0, node1});
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int cost = arr[0], cur = arr[1];
            if(cur == node2) return cost;
            for(int[] e : graph[cur]){
                int next = e[0];
                int ncost = e[1];
                if(dist[next] > cost + ncost){
                    dist[next] = cost + ncost;
                    pq.offer(new int[]{cost + ncost, next});
                }
            }
        }
        return -1;
    }
}
