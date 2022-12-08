package leetcode.tree;

public class forTest {
    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int i = numIslands.numIslands(grid);
        System.out.println(i+"");

    }
}
