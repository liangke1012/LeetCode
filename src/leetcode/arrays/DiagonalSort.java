package leetcode.arrays;

import java.util.Arrays;

public class DiagonalSort {
    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2}, {1,1,1,2}};
        int[][] res = diagonalSort(mat);
        System.out.println(Arrays.toString(res[0]));
    }

    private static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) {
            int lefti = Math.max(k, 0);
            int righti = Math.min(k + n, m);
            for (int i = lefti; i < righti; i++) {
                a[i - lefti] = mat[i][i - k];
            }
            Arrays.sort(a, 0, righti - lefti);
            for (int i = lefti; i < righti; i++) {
                mat[i][i - k] = a[i - lefti];
            }
        }
        return mat;
    }
}
