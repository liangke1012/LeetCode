package leetcode.graph;

public class TestGraph {
    public static void main(String[] args) {
        int[][] graph = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        Graph2642 g = new Graph2642(4, graph);
        System.out.println(g.shortestPath(3,2));
    }
}
