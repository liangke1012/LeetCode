package leetcode.tanxin;

import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {
    public static void main(String[] args) {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        int ans = minimumRounds(tasks);
        System.out.println(ans);
    }

    private static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for (int v : map.values()) {
            if (v == 1) {
                return -1;
            } else if ( v % 3 == 0 ){
                ans += v / 3;
            } else {
                ans += v / 3 + 1;
            }
        }
        return ans;
    }
}
