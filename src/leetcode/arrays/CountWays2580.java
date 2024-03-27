package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountWays2580 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        int[][] nums = {{1,3},{10,20},{2,5},{4,8}};
        int res = countWays(nums);
        System.out.println(res);
    }

    private static int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int n = ranges.length;
        int res = 1;
        for (int i = 0; i < n;) {
            int r = ranges[i][1];
            int j = i + 1;
            while (j < n && ranges[j][0] <= r) {
                r = Math.max(r, ranges[j][1]);
                j++;
            }
            res = res * 2 % MOD;
            i = j;
        }
        return res;
    }
}
