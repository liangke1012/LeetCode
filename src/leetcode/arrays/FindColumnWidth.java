package leetcode.arrays;

import java.util.Arrays;

public class FindColumnWidth {
    public static void main(String[] args) {
        int[][] grid = {{-15,1,3},{15,7,12},{5,6,-2}};
        int[] res = findColumnWidth(grid);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findColumnWidth(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j] = Math.max(res[j], String.valueOf(grid[i][j]).length());
            }
        }
        return res;
    }
}
