package leetcode.tree;

/**
 * 创建二叉排序树
 */
public class BinarySortTree {

     private TreeNode root;
     //添加结点
     public void add(TreeNode node){
         if(root == null){
             root = node;
         }else {
             root.add(node);
         }
     }

     public void infixOrder(){
         if(root != null){
             root.infixOrder();
         }else {
             System.out.println("null");
         }
     }

    /**
     * 查找要删除的结点
     */
    public TreeNode search(int value){
        if(root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public TreeNode searchParent(int value){
        if(root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除一个结点
     */
      public void delNode(int value){
          if(root == null){
              return;
          }else{
              TreeNode target = search(value);
              if(target == null){
                  return;
              }
              if(root.left==null && root.right == null){
                  root = null;
                  return;
              }
              TreeNode parent = searchParent(value);
              //1、叶子结点
              if(target.left == null && target.right == null){
                  if(parent.left != null && parent.left.val == value){
                      parent.left = null;
                  }else if(parent.right != null && parent.right.val == value){
                      parent.right = null;
                  }
              } else if (target.left!=null && target.right != null) {//左右结点都有
                  int temp = RightTreeMin(target.right);
                  target.val = temp;
              }else{
                  //删除只有一颗子树的结点
                  //只有左子树
                  if(target.left != null){

                          if(parent.left.val == value){
                              parent.left = target.left;
                          }else {
                              parent.right = target.left;
                          }

                  }else {
                      //只有右子树

                          if(parent.left.val == value){
                              parent.left = target.right;
                          }else {
                              parent.right = target.right;
                          }

                  }
              }
          }
      }

    private int RightTreeMin(TreeNode node) {
           TreeNode target = node;
           while (target.left!=null){
               target = target.left;
           }
        delNode(target.val);
           return target.val;
    }
}
