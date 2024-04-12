package leetcode.arrays;

public class FindChampion {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,0,1},{0,0,0}};
        int res = findChampion(grid);
        System.out.println(res);
    }

    private static int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] lines = grid[i];
            int sum = 0;
            for (int line : lines) {
                sum += line;
            }
            if (sum == n - 1){
                return i;
            }
        }
        return -1;
    }
}
