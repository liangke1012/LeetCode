package leetcode.arrays;

public class MaxDivScore {
    public static void main(String[] args) {
        int[] nums = {4,7,9,3,9};
        int[] divisors = {5,2,3};
        int res = maxDivScore(nums, divisors);
        System.out.println(res);
    }

    private static int maxDivScore(int[] nums, int[] divisors) {
        int cnt = -1, ans = 0;
        for (int i = 0; i < divisors.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    tmp++;
                }
            }
            if (tmp > cnt || (tmp == cnt && divisors[i] < ans)) {
                cnt = tmp;
                ans = divisors[i];
            }
        }
        return ans;
    }
}
