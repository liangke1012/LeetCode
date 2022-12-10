package leetcode.tree;

import java.util.Arrays;
import java.util.List;

public class forTest {
    public static void main(String[] args) {
//        NumIslands numIslands = new NumIslands();
//        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
//        int i = numIslands.numIslands(grid);
//        System.out.println(i+"");

        BuildTree buildTree = new BuildTree();
        int[] preorder = {1,2,3,4,5,6,7};
        int[] inorder = {9,3,15,20,7};
       // TreeNode treeNode = buildTree.buildTree(preorder, inorder);
       // System.out.println(treeNode);

        TreeNode bst1 = buildTree.sortedArrayToBST(preorder);


    }
}
