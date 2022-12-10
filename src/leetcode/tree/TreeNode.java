package leetcode.tree;

public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;

      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    /**
     * 二叉排序树新增结点
     * @param node
     */
    public void add(TreeNode node){
        if(node == null){
            return;
        }
        if(node.val < this.val){
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    /**
     * 查找要删除的结点
     * @param val
     * @return
     */
    public TreeNode search(int val){
        if(val == this.val) {
            return this;
        } else if (val < this.val) {
            if(this.left == null){
                return null;
            }
           return this.left.search(val);
        }else {
            if(this.right == null){
                return null;
            }
            return this.right.search(val);
        }
    }

    /**
     * 查找要删除结点的父节点
     */
     public TreeNode searchParent(int val){
         if((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)){
             return this;
         }else {
             if(val < this.val && this.left != null){
                 return this.left.searchParent(val);
             }else if(val > this.val && this.right != null){
                 return this.right.searchParent(val);
             }else {
                 return null;
             }
         }
     }

}
