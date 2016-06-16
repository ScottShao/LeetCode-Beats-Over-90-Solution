public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = liveNeighbours(board, i, j, m, n);
                if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (liveCount == 3 || liveCount == 4) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] & 2) >>> 1;
            }
        }
    }
    
    private int liveNeighbours(int[][] board, int i, int j, int m, int n) {
        int lx = Math.max(i - 1, 0);
        int hx = Math.min(i + 1, m - 1);
        int ly = Math.max(j - 1, 0);
        int hy = Math.min(j + 1, n - 1);
        int count = 0;
        for (int x = lx; x <= hx; x++) {
            for (int y = ly; y <= hy; y++) {
                count += (board[x][y] & 1);
            }
        }
        return count;
    }
}