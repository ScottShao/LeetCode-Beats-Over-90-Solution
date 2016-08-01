public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] horizontal = new boolean[10][10];
        boolean[][] vertical = new boolean[10][10];
        boolean[][] square = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int idx = i / 3 * 3+ j / 3;
                if (horizontal[i][num] || vertical[j][num] || square[idx][num]) {
                    return false;
                }
                horizontal[i][num] = true;
                vertical[j][num] = true;
                square[idx][num] = true;
            }
        }
        return true;
    }
}