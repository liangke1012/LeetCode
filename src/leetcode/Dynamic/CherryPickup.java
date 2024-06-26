package leetcode.Dynamic;

import java.util.Arrays;

public class CherryPickup {
    public static void main(String[] args) {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        int res = cherryPickup(grid);
        System.out.println(res);
    }

    private static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        f[0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(k - n + 1, 0); --x1) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; --x2) {
                    int y1 = k -x1,y2 = k - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        f[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }
                    int res = f[x1][x2]; // 都往右
                    if (x1 > 0) {
                        res = Math.max(res, f[x1 - 1][x2]); // 往下，往右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[x1][x2 - 1]); // 往右，往下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[x1 - 1][x2 - 1]); // 都往下
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) { // 避免重复摘同一个樱桃
                        res += grid[x2][y2];
                    }
                    f[x1][x2] = res;
                }
            }
        }
        return Math.max(f[n - 1][n - 1], 0);
    }
}
