package leetcode.arrays;

public class GetWinner {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        int res = getWinner(arr, k);
        System.out.println(res);
    }

    private static int getWinner(int[] arr, int k) {
        int max = arr[0];
        int win = 0;
        for (int i = 1; i < arr.length && win < k; i++) {
            if (arr[i] > max) {
                max = arr[i];
                win = 0;
            }
            win++;
        }
        return max;
    }
}

