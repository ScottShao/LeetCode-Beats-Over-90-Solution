public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] vals = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, vals, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, char[] vals, int index) {
        if (index == vals.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != vals[index]) {
            return false;
        }
        board[i][j] ^= 256;
        index++;
        boolean isFound = dfs(board, i - 1, j, vals, index) || dfs(board, i + 1, j, vals, index) ||
                        dfs(board, i, j - 1, vals, index) || dfs(board, i, j + 1, vals, index);
        board[i][j] ^= 256;
        return isFound;
    }
    
    
}