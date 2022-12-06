package leetcode.backtract;

import java.util.List;

public class ForTest {
    public static void main(String[] args) {
//        lc90 lc90 = new lc90();
//        int[] nums = {1,2,2};
//        List<List<Integer>> lists = lc90.subsetsWithDup(nums);
//        System.out.println(lists.toString());

        int[] nums2 = {1,2,3};
        lc46 lc46 = new lc46();
        List<List<Integer>> permute = lc46.permute(nums2);
        System.out.println(permute.toString());

    }
}
