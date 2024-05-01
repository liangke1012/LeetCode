package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TotalCost2462 {
    public static void main(String[] args) {
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 2;
        long res = totalCost(costs, k ,candidates);
        System.out.println(res);
    }

    private static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long res = 0;
        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }

        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }
        int i = candidates;
        int j = n - 1 - candidates;
        while (k-- > 0){
            if (pre.poll() <= pre.poll()) {
                res += pre.poll();
                pre.offer(costs[i++]);
            } else {
                res += suf.poll();
                suf.offer(costs[j--]);
            }
        }
        return res;
    }
}
