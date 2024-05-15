package leetcode.tanxin;

import java.util.Arrays;

public class FindMinimumTime {
    public static void main(String[] args) {
        int[][] tasks = {{2,3,1}, {4,5,1},{1,5,2}};
        int ans = findMinimumTime(tasks);
        System.out.println(ans);
    }

    private static int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1];
        for (int[] t : tasks) {
            int start = t[0];
            int end = t[1];
            int d = t[2];
            for (int i = start;i <= end; i++){
                if (run[i]) {
                    d--;
                }
            }
            for (int i = end; d > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }

}
