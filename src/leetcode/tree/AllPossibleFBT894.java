package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT894 {
    public static void main(String[] args) {
        int n = 7;
        List<TreeNode> res = allPossibleFBT(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }

    }

    private static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> fullBinaryTrees = new ArrayList<TreeNode>();
        if (n % 2 == 0) {
            return fullBinaryTrees;
        }
        if (n == 1) {
            fullBinaryTrees.add(new TreeNode(0));
            return fullBinaryTrees;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode root = new TreeNode(0, leftSubtree, rightSubtree);
                    fullBinaryTrees.add(root);
                }
            }
        }
        return fullBinaryTrees;
    }
}
