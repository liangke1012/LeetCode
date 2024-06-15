package leetcode.arrays;

import java.util.Arrays;

public class MaximumBeauty {
    public static void main(String[] args) {
        int[] nums = {4,6,1,2};
        int k = 2;
        int res = maximumBeauty(nums, k);
        System.out.println(res);
    }

    private static int maximumBeauty(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] - 2 * k > nums[j]) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
