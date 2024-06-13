package leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMaximumElegance {
    public static void main(String[] args) {
        int[][] nums = {{3,1},{3,1},{2,2},{5,3}};
        int k = 3;
        long res = findMaximumElegance(nums, k);
        System.out.println(res);
    }

    private static long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        Set<Integer> categorySet = new HashSet<>();
        long profit = 0;
        long res = 0;
        var st = new ArrayDeque<Integer>();
        for (int i = 0; i < items.length; i++) {
            if (i < k) {
                profit += items[i][0];
                if (!categorySet.add(items[i][1])) {
                    st.push(items[i][0]);
                }
            } else if (!st.isEmpty() && categorySet.add(items[i][1])) {
                profit += items[i][0] - st.pop();
            }
            res = Math.max(res, profit + (long)categorySet.size() * categorySet.size());
        }
        return res;
    }
}