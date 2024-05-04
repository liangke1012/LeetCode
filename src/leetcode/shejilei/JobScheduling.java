package leetcode.shejilei;

import java.util.Arrays;

public class JobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        int res = jobScheduling(startTime, endTime, profit);
        System.out.println(res);
    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    private static int search(int[][] jobs, int right, int upper) {
        int left = -1;
        while (left + 1 <right) {
            int mid = (left + right) >>> 1;
            if (jobs[mid][1] <= upper) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
