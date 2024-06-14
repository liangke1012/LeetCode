package leetcode.Dynamic;

import java.util.Map;

public class MaxScore {
    public static void main(String[] args) {
        int[] nums = {2,3,6,1,9,2};
        int x = 5;
        long res = maxScore(nums, x);
        System.out.println(res);
    }

    private static long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = (int) (nums[i] % 2);
            long cur = Math.max(dp[parity] + nums[i], dp[1 - parity] - x + nums[i]);
            res = Math.max(cur, res);
            dp[parity] = Math.max(dp[parity], cur);
        }
        return res;
    }

}
