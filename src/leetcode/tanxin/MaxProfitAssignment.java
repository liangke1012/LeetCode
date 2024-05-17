package leetcode.tanxin;

import java.util.Arrays;

public class MaxProfitAssignment {
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        int res = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(res);
    }

    private static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(worker);
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        int ans = 0, j = 0, maxProfit = 0;
        for (int work : worker) {
            while (j < n && work >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;
    }
}
