package leetcode.Dynamic;

import java.util.Arrays;

public class PaintWalls {
    public static void main(String[] args) {
        int[] cost = {1,2,3,2};
        int[] time = {1,2,3,2};
        int res = paintWalls(cost, time);
        System.out.println(res);
    }

    private static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 防止加法溢出
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i];
            int t = time[i] + 1; // 注意这里加一了
            for (int j = n; j > 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
            }
        }
        return f[n];
    }

}
