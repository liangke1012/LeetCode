package leetcode.arrays;

public class WateringPlants2 {
    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacityA = 4;
        int capacityB = 3;
        int res = minimumRefill(plants, capacityA, capacityB);
        System.out.println(res);
    }

    private static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int a = capacityA;
        int b = capacityB;
        int i = 0;
        int j = plants.length - 1;
        while (i < j) {
            if (a < plants[i]) {
                ans++;
                a = capacityA;
            }
            a -= plants[i++];
            if (b < plants[j]) {
                ans++;
                b = capacityB;
            }
            b -= plants[j--];
        }
        if (i == j && Math.max(a,b) < plants[i]) {
            ans++;
        }
        return ans;
    }
}
