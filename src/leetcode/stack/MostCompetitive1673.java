package leetcode.stack;

public class MostCompetitive1673 {
    public static void main(String[] args) {
        int[] nums = {2,4,3,3,5,4,9,6};
        int k = 4;
        int[] res = mostCompetitive(nums, k);
    }

    private static int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] sk = new int[k];
        int m = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (m > 0 && x < sk[m - 1] && m + n - i > k){
                m--;
            }
            if (m < k){
                sk[m++] = x;
            }
        }
        return sk;
    }
}
