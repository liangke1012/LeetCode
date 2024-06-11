package leetcode.arrays;

public class CountBattleships {
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        int res = countBattleships(board);
        System.out.println(res);
    }

    private static int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' &&
                        (j == 0 || board[i][j - 1] != 'X') &&
                        (i == 0 || board[i - 1][j] != 'X'))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
