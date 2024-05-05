package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Decrypt {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        int[] res = decrypt(code, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int r = k > 0 ? k + 1 : n;
        k = Math.abs(k);
        int s = 0;
        for (int i = r - k; i < r; i++) {
            s += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = s;
            s += code[r % n] - code[(r - k) % n];
            r++;
        }
        return res;
    }
}
