public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] horizontal = new int[10][10];
        int[][] vertical = new int[10][10];
        int[][] square = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (horizontal[i][num] > 0) {
                    return false;
                }
                horizontal[i][num]++;
                if (vertical[j][num] > 0) {
                    return false;
                }
                vertical[j][num]++;
                int idx = i / 3 * 3+ j / 3;
                if (square[idx][num] > 0) {
                    return false;
                }
                square[idx][num]++;
            }
        }
        return true;
    }
}