package leetcode.arrays;

import java.util.*;

public class MinOperations2009 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6};
        int res = minOperations(nums);
        System.out.println(res);
    }

    private static int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> sortedNums = new ArrayList<>(set);
        Collections.sort(sortedNums);
        int res = n;
        int j = 0;
        for (int i = 0; i < sortedNums.size(); i++) {
            int left = sortedNums.get(i);
            int right = left + n - 1;
            while (j < sortedNums.size() && sortedNums.get(j) <= right) {
                res = Math.min(res, n - j + i -1);
                j++;
            }
        }
        return res;
    }
}
