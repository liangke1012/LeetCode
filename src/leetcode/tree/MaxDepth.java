package leetcode.tree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left!=null){
            leftDepth = maxDepth(root.left);
        }
        if(root.right!=null){
            rightDepth = maxDepth(root.right);
        }
        depth = leftDepth > rightDepth ? leftDepth+1:rightDepth+1;
        return depth;
    }

}
