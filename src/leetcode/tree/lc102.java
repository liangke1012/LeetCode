package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class lc102 {
    public static void main(String[] args) {

    }
    private static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for(int i = 1;i<=len;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right!= null){
                    queue.offer(node.right);
                }

            }
            res.add(level);
        }
        return res;
    }
}
