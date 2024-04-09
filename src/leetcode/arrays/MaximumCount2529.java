package leetcode.arrays;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 */
public class MaximumCount2529 {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,2,3};
        int res = maximumCount(nums);
        System.out.println(res);
    }

    private static int maximumCount(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    private static int lowerBound(int[] nums, int val) {
        int l = 0;
        int r = nums.length;
        while( l < r){
            int mid = (l + r) / 2;
            if (nums[mid] >= val) {
                r = mid;
            } else{
                l = mid + 1;
            }
        }
        return l;
    }
}
