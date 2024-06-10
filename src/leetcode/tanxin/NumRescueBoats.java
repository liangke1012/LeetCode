package leetcode.tanxin;

import java.util.Arrays;

public class NumRescueBoats {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit = 3;
        int res = numRescueBoats(people, limit);
        System.out.println(res);
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                ++left;
            }
            --right;
            ans++;
        }
        return ans;
    }
}
