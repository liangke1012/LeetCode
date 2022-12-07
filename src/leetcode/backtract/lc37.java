package leetcode.backtract;

import java.util.ArrayList;
import java.util.List;

public class lc37 {
    private boolean[][] line = new boolean[9][9]; // 每行中是否取到那个数
    private boolean[][] column = new boolean[9][9]; // 每列中是否取到那个数
    private boolean[][][] block = new boolean[3][3][9]; // 每个3*3小方块里是否取到那个数
    private List<int[]> spaces = new ArrayList<>(); // 用于存放空格字符的坐标

    private boolean valid = false; // 用于记录是否遍历完

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int x = board[i][j] - '0' - 1;
                    // 是数字的话,需要修改上面创建好的数组
                    line[i][x] = column[j][x] = block[i / 3][j / 3][x] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit){
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }

    }
}
