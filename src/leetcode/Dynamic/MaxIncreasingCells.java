package leetcode.Dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxIncreasingCells {
    public static void main(String[] args) {
        int[][] mat = {{3,1,6},{-9,5,7}};
        int res = maxIncreasingCells(mat);
        System.out.println(res);
    }

    private static int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<Integer, List<int[]>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int ans = 0;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] mx = new int[pos.size()]; // 先把最大值算出来，再更新 rowMax 和 colMax
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                mx[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, mx[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]); // 更新第 i 行的最大 f 值
                colMax[j] = Math.max(colMax[j], mx[k]); // 更新第 j 列的最大 f 值
            }
        }
        return ans;
    }
}
