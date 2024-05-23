package leetcode.arrays;

import java.util.*;

public class LongestEqualSubarray {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,3,2,3,1,3);
        int k = 3;
        int ans = longestEqualSubarray(nums, k);
        System.out.println(ans);
    }

    private static int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> vec : map.values()) {
            for (int i = 0, j = 0; i < vec.size(); i++) {
                while (vec.get(i) - vec.get(j) - (i - j) > k) {
                    j++;
                }
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }
}
