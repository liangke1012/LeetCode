package leetcode.backtract;

import java.util.*;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 */

public class lc40 {
    public static void main(String[] args) {
        int[] can = {1,1,2,2,3,4};
        List<List<Integer>> lists = combinationSum2(can, 5);
        System.out.println(lists.toString());
    }
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates,len,0,target,path,res);

        return res;
    }

    /**
     *
     * @param candidates
     * @param len
     * @param begin
     * @param target
     * @param path
     * @param res
     */
    private static void backtrack(int[] candidates, int len, int begin, int target, Deque<Integer> path,List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i<len;i++){
            if(target-candidates[i] < 0){
                break;
            }
            if(i > begin && candidates[i] == candidates[i -1]){
                continue;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
// 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            backtrack(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));

        }
    }

}
