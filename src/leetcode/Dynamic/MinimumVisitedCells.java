package leetcode.Dynamic;

public class MinimumVisitedCells {
    public static void main(String[] args) {
        int[][] grid = {{3,4,2,1},{4,2,3,1},{2,1,0,0},{12,4,0,0}};
        int res = minimumVisitedCells(grid);
        System.out.println(res);
    }

    private static int minimumVisitedCells(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        return 0;
    }
}
