package leetcode.Dynamic;

import java.util.Arrays;

public class MaxOperations {
    private static int[] nums;
    private static int[][] memo;
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4};
        int res = maxOperations(nums);
        System.out.println(res);
    }

    private static int maxOperations(int[] array) {
        int n = array.length;
        nums = array;
        memo = new int[n][n];
        int res1 = helper(2, n - 1, nums[0] + nums[1]); // 删除前两个数
        int res2 = helper(0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个数
        int res3 = helper(1, n - 2, nums[0] + nums[n - 1]); // 删除第一个和最后一个数
        return Math.max(Math.max(res1, res2), res3) + 1;
    }

    private static int helper(int i, int j, int target) {
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(i, j, target);
    }

    private static int dfs(int i, int j, int target) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        if (nums[i] + nums[i + 1] == target) { // 删除前两个数
            res = Math.max(res, dfs(i + 2, j, target) + 1);
        }
        if (nums[j - 1] + nums[j] == target) { // 删除后两个数
            res = Math.max(res, dfs(i, j - 2, target) + 1);
        }
        if (nums[i] + nums[j] == target) { // 删除第一个和最后一个数
            res = Math.max(res, dfs(i + 1, j - 1, target) + 1);
        }
        return memo[i][j] = res; // 记忆化
    }

}
