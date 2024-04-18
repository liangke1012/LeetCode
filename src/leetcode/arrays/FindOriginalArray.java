package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArray {
    public static void main(String[] args) {
        int[] changed = {1,2,3,2,4,6};
        int[] res = findOriginalArray(changed);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int[] res = new int[changed.length / 2];
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : changed) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int i = 0;
        for (int a : changed){
            if (count.get(a) == 0) {
                continue;
            }
            count.put(a, count.get(a) - 1);
            if (count.getOrDefault(a * 2, 0) == 0){
                return new int[0];
            }
            count.put(a * 2, count.get(a * 2) - 1);
            res[i++] = a;
        }
        return res;
    }
}
