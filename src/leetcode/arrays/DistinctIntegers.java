package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class DistinctIntegers {
    public static void main(String[] args) {
        int n = 5;
        int res = distinctIntegers(n);
        System.out.println(res);
    }

    private static int distinctIntegers(int n) {
        HashSet<Integer> nums = new HashSet<>();
        if (n == 1){
            return 1;
        }
        for (int x = 1; x <= n; x++) {
            for (int i = 1; i <=n ; i++) {
                if (x % i == 1) {
                    nums.add(i);
                }
            }
        }

        return nums.size();
    }
}
