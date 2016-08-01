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
                if (horizontal[i][num]) {
                    return false;
                }
                horizontal[i][num] = true;
                if (vertical[j][num]) {
                    return false;
                }
                vertical[j][num] = true;
                int idx = i / 3 * 3+ j / 3;
                if (square[idx][num]) {
                    return false;
                }
                square[idx][num] = true;
            }
        }
        return true;
    }
}