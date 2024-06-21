package leetcode.arrays;

public class TemperatureTrend {
    public static void main(String[] args) {
        int[] temperatureA = {5,10,16,-6,15,11,3};
        int[] temperatureB = {16,22,23,23,25,3,-16};
        int res = temperatureTrend(temperatureA, temperatureB);
        System.out.println(res);
    }

    private static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int cur = 0;
        for (int i = 1; i < n; i++) {
            int ta = getTrend(temperatureA[i], temperatureA[i - 1]);
            int tb = getTrend(temperatureB[i], temperatureB[i - 1]);
            if (ta == tb) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
        }
        return ans;
    }

    private static int getTrend(int a, int b) {
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : -1;
    }


}
