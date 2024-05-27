package leetcode.arrays;

import java.util.Arrays;

public class MissingRolls {
    public static void main(String[] args) {
        int[] rolls = {1,5,6};
        int mean = 4;
        int n = 2;
        int[] res = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(res));
    }

    private static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (m + n);
        int missingSum = total;
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int avg = missingSum / n;
        int rem = missingSum % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = avg + (i < rem ? 1 : 0);
        }
        return res;
    }
}
