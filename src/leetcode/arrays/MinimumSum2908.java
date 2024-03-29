package leetcode.arrays;

public class MinimumSum2908 {
    public static void main(String[] args) {
        int[] nums = {8,6,1,5,3};
        int res = minimumSum(nums);
        System.out.println(res);
    }

    private static int minimumSum(int[] nums) {
        int n = nums.length;
        int res = 1000;
        int mn = 1000;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = mn = Math.min(nums[i - 1], mn);
        }
        int right = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (left[i] < nums[i] && nums[i] > right) {
                res = Math.min(res, left[i] + nums[i] + right);
            }
            right = Math.min(right, nums[i]);
        }

        return res < 1000 ? res : -1;
    }
}
