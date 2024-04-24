package leetcode.tree;

import java.util.*;

public class AmountOfTime {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(graph, root);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nodeVal = arr[0];
            time = arr[1];
            for (int childVal : graph.get(nodeVal)) {
                if (visited.add(childVal)) {
                    queue.offer(new int[]{childVal, time + 1});
                }
            }
        }
        return time;
    }

    /**
     * 先将树的结构用深度优先搜索解析成无向图,graph\textit{graph}graph 即为邻接表，用一个哈希表来表示。哈希表的键为节点值，值为其相邻节点的值组成的列表。
     * @param graph
     * @param node
     */
    private void dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
        graph.putIfAbsent(node.val, new ArrayList<>());
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null) {
                graph.get(node.val).add(child.val);
                graph.putIfAbsent(child.val, new ArrayList<>());
                graph.get(child.val).add(node.val);
                dfs(graph, child);
            }
        }
    }
}
