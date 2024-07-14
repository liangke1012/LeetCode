package leetcode.arrays;

public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][]  grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int res = maxIncreaseKeepingSkyline(grid);
        System.out.println(res);
    }

    private static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int res = 0;
        int[] col = new int[n];
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(col[j], row[i]) - grid[i][j];
            }
        }
        return res;
    }
}
