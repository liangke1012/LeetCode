package leetcode.tanxin;

public class MaxArrayValue_2789 {
    public static void main(String[] args) {
        int[] nums = {2,3,7,9,3};
        long res = maxArrayValue(nums);
        System.out.println(res);
    }

    private static long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        long res = nums[len - 1];
        for (int i = len - 2; i >= 0 ; i--) {
            res = res >= nums[i] ? res + nums[i] : nums[i];
        }
        return res;
    }
}
