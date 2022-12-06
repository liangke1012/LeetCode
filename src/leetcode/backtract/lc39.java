package leetcode.backtract;

import java.util.ArrayList;
import java.util.List;

public class lc39 {
    public static void main(String[] args) {
      int[] candiates = {2,2,3,4,5};
      List<List<Integer>> res = combinationSum(candiates,7);
      System.out.println(res.toString());

    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        //每次我们可以选择跳过不用第 idx个数，即执行 dfs(target,combine,idx+1)
        // 也可以选择使用第 idx个数，即执行 dfs(target−candidates[idx],combine,idx)
        dfs(candidates,target,ans,combine,index+1);
        if(target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,combine,index);
            combine.remove(combine.size()-1);
        }
    }
}
