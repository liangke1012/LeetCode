package leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MincostToHireWorkers {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int k = 2;
        double res = mincostToHireWorkers(quality, wage, k);
        System.out.println(res);
    }

    private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] id = new Integer[n];
        Arrays.setAll(id, i ->i);

        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i] );

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int sumQ = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[id[i]]);
            sumQ += quality[id[i]];
        }
        double ans = sumQ * ((double) wage[id[k - 1]] / quality[id[k - 1]]);
        for (int i = k; i < n; i++) {
            int q = quality[id[i]];
            if (q < pq.peek()) {
                sumQ -= pq.poll() - q;
                pq.offer(q);
                ans = Math.min(ans, sumQ * ((double) wage[id[i]] / q));
            }
        }
        return ans;
    }
}
