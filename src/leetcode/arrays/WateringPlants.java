package leetcode.arrays;

public class WateringPlants {
    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacity = 5;
        int res = wateringPlants(plants, capacity);
        System.out.println(res);
    }

    private static int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0;
        int reset = capacity;
        for (int i = 0; i < n; i++) {
            if (reset >= plants[i]) {
                ++ans;
                reset -= plants[i];
            } else {
                ans += i * 2 + 1;
                reset = capacity - plants[i];
            }
        }
        return ans;
    }
}
