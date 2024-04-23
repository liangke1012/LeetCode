package leetcode.arrays;

public class MaxSatisfied1052 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int res = maxSatisfied(customers, grumpy, minutes);
        System.out.println(res);
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                total += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if(i >= minutes) {
                cur -= customers[i - minutes];
            }
            max = Math.max(max, cur);
        }
        return total + max;
    }
}
