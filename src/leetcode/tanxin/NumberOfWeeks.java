package leetcode.tanxin;

public class NumberOfWeeks {
    public static void main(String[] args) {
        int[] milestones = {3,2,1};
        long ans = numberOfWeeks(milestones);
        System.out.println(ans);
    }

    private static long numberOfWeeks(int[] milestones) {
        long longest = milestones[0];
        long rest = 0;
        for (int count : milestones) {
            longest = Math.max(count, longest);
            rest += count;
        }
        rest -= longest;
        if (longest <= rest + 1) {
            return longest + rest;
        } else {
            return rest * 2 + 1;
        }
    }
}
