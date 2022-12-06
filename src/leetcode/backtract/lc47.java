package leetcode.backtract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        dfs1(nums,len,0,path,res,used);
        return res;
    }

    private void dfs1(int[] nums, int len, int index, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<len;i++){
            if(i > 0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs1(nums,len,index+1,path,res,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
