package leetcode.arrays;

import java.util.Arrays;

public class CanSortArray {
    public static void main(String[] args) {
        int[] nums = {4,2,8,30,15};
        boolean res = canSortArray(nums);
        System.out.println(res);
    }

    private static boolean canSortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n;) {
            int start = i;
            int ones = Integer.bitCount(nums[i++]);
            while (i < n && Integer.bitCount(nums[i]) == ones) {
                i++;
            }
            Arrays.sort(nums, start, i);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
