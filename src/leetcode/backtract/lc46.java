package leetcode.backtract;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,res,used);
        return res;
    }

    private void dfs(int[] nums, int len, int index, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,index+1,path,res,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
