package leetcode.tanxin;

import java.util.Arrays;

public class MinimumAddedCoins {
    public static void main(String[] args) {
        int[] nums = {1,4,10,5,7,19};
        int target = 19;
        int res = minimumAddedCoins(nums, target);
    }

    private static int minimumAddedCoins(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        int index = 0;
        int s = 1;
        while(s <= target) {
            if(index < len && nums[index] <= s) {
                s += nums[index];
                index++;
            }else {
                s += s;
                res++;
            }
        }
        return res;
    }
}
