package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    public static void main(String[] args) {
        int[] nums = {1,23,45,3,4,2};
        int len = longestConsecutive(nums);
        System.out.println(len);
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }
}
