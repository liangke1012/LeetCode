package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class OrangesRotting {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 四方向

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = orangesRotting(grid);
        System.out.println(ans);
    }

    private static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++; // 统计新鲜橘子个数
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j}); // 一开始就腐烂的橘子
                }
            }
        }
        int ans = -1;
        while (!q.isEmpty()) {
            ans++;
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] pos : tmp) {
                for (int[] d : DIRECTIONS) {
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if (i >=0 && i <m && j>=0 && j < n && grid[i][j] == 1) {
                        fresh--;
                        grid[i][j] = 2;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }

        return fresh > 0 ? -1 : Math.max(ans, 0);
    }
}
