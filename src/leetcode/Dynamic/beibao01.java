package leetcode.Dynamic;

public class beibao01 {
    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int bagweight = 4;
        int[][] dp = new int[weight.length][bagweight+1];
        for (int i = weight[0]; i <= bagweight; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1;j <= bagweight ; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }

        }
        System.out.println(dp[weight.length-1][bagweight]+"");
    }
}
