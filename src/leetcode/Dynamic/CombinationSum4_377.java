package leetcode.Dynamic;

public class CombinationSum4_377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int res = combinationSum4(nums, target);
        System.out.println();
    }

    private static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
