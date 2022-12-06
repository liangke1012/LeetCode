package leetcode.backtract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc78ziji {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res.toString());


    }


    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums,0,path,res);
        return res;
    }

    private static void backtracking(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if(index >= nums.length){
            return;
        }
        for(int i = index;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1,path,res);
            path.remove(path.size() - 1);
        }
    }
}
