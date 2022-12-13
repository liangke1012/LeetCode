package leetcode.Dynamic;

public class climbStairs {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }

    /**
     * 不能连续走2步
     * @param n
     * @return
     */
    public int CountNumber(int n,int status){
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            //上一步是走的两步， 则只能全走一步
            if (status == 2) {
                return 1;
            }
            //上一步是走的1步， 则可以全走一步，或者直接走两步
            if (status == 1) {
                return 2;
            }
        }

        if (n > 2) {
            if (status == 0) {
                return CountNumber(n - 1, 1) + CountNumber(n - 2, 2);
            }
            if (status == 1) {
                return CountNumber(n - 1, 1) + CountNumber(n - 2, 2);
            }
            if (status == 2) {
                return CountNumber(n - 1, 1);
            }
        }
        return CountNumber(n,0);
    }

    /**
     * 爬楼梯: 一次可以上 1、2、3 阶台阶
     */
    public int climbStairs3(int n){
        if (n<=2) return n;
        if (n==3) return 4;
        int x = 1, y = 2, z = 4, res = 0;
        for (int i=4; i<=n; i++) {
            res = x + y + z;
            x = y;
            y = z;
            z = res;
        }
        return res;
    }

    /**\
     * 如果每次可以上1、2、3阶台阶，并且相邻的步伐不能相同，有多少种方法
     *
     */
    public int climbStairs31(int n) {
        if (n <= 2) return n;
        if (n == 3) return 2;
        // 走n阶台阶，第一步可以走1、2、3
        int[][] dp = new int[n + 1][4];
        // n=1 时，第一步只能走 1步
        dp[1][1] = 1;
        // n=2 时， 第一步只能走 1步
        dp[2][2] = 1;
        // n=3 时，第一步可以走 1 步、2步
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= n; i++) {
            // 走i步：第一步走1步=第二步走2步+第二步走3步
            dp[i][1] = dp[i - 1][2] + dp[i - 1][3];
            // 走i步：第一步走2步=第二步走1步+第二步走3步
            dp[i][2] = dp[i - 2][1] + dp[i - 2][3];
            // 走i步：第一步走3步=第二步走1步+第二步走2步
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2];
        }
        // 上n阶台阶 = 第一步走1步 + 第一步走2步 + 第一步走3步
        return dp[n][1] + dp[n][2] + dp[n][3];
    }

}
