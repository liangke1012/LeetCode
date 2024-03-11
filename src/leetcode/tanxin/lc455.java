package leetcode.tanxin;

import java.util.Arrays;
import java.util.Map;

public class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        int result = 0;
        for(int i = g.length -1;i>=0;i--){
            if(index >= 0 && s[index] >= g[i]){
                result++;
                index--;
            }
        }
        return result;
    }

    /**
     * leetcode 53 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count +=nums[i];
            if(count > result){
                result = count;
            }
            if(count <= 0) count = 0;
        }
        return result;
    }

    /**
     * leetcode55 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i+nums[i],cover);
            if(cover >= nums.length-1){
                return true;
            }
        }
        return false;
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length == 1)return 0;
        int curdistance = 0;  //当前覆盖最远距离的下标
        int ans = 0;
        int nextDistance = 0;  //下一步覆盖最远距离的下标
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i,nextDistance);
            if(i == curdistance){
                if(curdistance != nums.length-1){
                    ans++;
                    curdistance = nextDistance;
                    if(nextDistance >= nums.length -1) break;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
