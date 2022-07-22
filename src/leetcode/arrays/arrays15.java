package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

 注意：答案中不可以包含重复的三元组。
 **/
public class arrays15 {
    public static void main(String[] args) {
         int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.println(threeSum.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null | len < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            int l = i + 1;
            int r = len -1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[l],nums[r]));
                    while(l < r && nums[l] == nums[l+1]){l++;}
                    while(l < r && nums[r] == nums[r-1]){r--;}
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}
