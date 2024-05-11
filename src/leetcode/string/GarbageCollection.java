package leetcode.string;

public class GarbageCollection {
    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        int res = garbageCollection(garbage, travel);
        System.out.println(res);
    }

    private static int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        for (String s : garbage) {
            ans += s.length();
        }
        for (int t : travel) {
            ans += t * 3;
        }
        for (char c : new char[]{'G','M','P'}){
            for (int i = garbage.length - 1; i > 0 && garbage[i].indexOf(c) < 0 ; i--) {
                ans -= travel[i - 1];
            }
        }
        return ans;
    }
}
