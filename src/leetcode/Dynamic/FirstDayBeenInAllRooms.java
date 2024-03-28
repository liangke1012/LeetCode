package leetcode.Dynamic;

public class FirstDayBeenInAllRooms {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        int[] nextvisit = {0,0,2};
        int res = firstDayBeenInAllRooms(nextvisit);
        System.out.println(res);
    }

    private static int firstDayBeenInAllRooms(int[] nextvisit) {
        int len = nextvisit.length;
        int[] dp = new int[len];
        dp[0] = 2;
        for (int i = 1; i < len; i++) {
            int to = nextvisit[i];
            dp[i] = 2 + dp[i - 1];
            if(to != 0) {
                dp[i] = (dp[i] - dp[to - 1] + MOD) % MOD;
            }
            dp[i] = (dp[i] + dp[i - 1]) % MOD;
        }
        return dp[len - 2];
    }

}
