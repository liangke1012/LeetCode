package leetcode.string;

import java.util.Arrays;

public class LongestAwesome {
    public static void main(String[] args) {
        String s = "3242415";
        int res = longestAwesome(s);
        //System.out.println(1 << 10);
        System.out.println(res);
    }

    private static int longestAwesome(String s) {
        int n = s.length();
        int[] pos = new int[1 << 10];
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < 10; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            ans = Math.max(ans, i - pos[pre]); // 偶数
            if (pos[pre] == n) { // 首次遇到值为 pre 的前缀异或和，记录其下标 i
                pos[pre] = i;
            }
        }
        return ans;
    }
}
