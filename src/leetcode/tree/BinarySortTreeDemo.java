package leetcode.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new TreeNode(arr[i]));
        }
        binarySortTree.infixOrder();
        binarySortTree.delNode(2);
        System.out.println("========================================================");
        binarySortTree.infixOrder();
    }
}
