package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNums {

    public List<List<Integer>> threeSum(int[] nums) {
         int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null || nums.length < 3){
            return res;
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) break;
            if( i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l] == nums[l+1]) l++; // 去重
                    while (l<r && nums[r] == nums[r-1]) r--; // 去重
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
    }
}
