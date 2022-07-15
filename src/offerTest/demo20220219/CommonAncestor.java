package offerTest.demo20220219;

/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 */
public class CommonAncestor {


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return  null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        return (left !=null) ? left : right;
    }

    public class TreeNode{
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}


