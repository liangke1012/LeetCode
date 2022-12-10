package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateTree(1,n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTree(start,i -1);
            List<TreeNode> righrTree = generateTree(i+1,end);
            for(TreeNode left : leftTree){
                for(TreeNode right : righrTree){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    list.add(currTree);
                }
            }
        }
        return list;
    }

    /**
     * leetcode 96
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        return dp[n];
    }
}
