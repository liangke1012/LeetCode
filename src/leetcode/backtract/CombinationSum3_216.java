package leetcode.backtract;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {
    static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        List<List<Integer>> res = combinationSum3(k, n);
        System.out.println(res.toString());
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }

    private static void dfs(int cur, int n, int k, int sum) {
        if (temp.size() + n - cur + 1 < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur + 1, n, k, sum);
        temp.remove(temp.size() - 1);
        dfs(cur+ 1, n, k, sum);
    }


}
