public class Solution {
    private long MASK;
    public int totalNQueens(int n) {
        MASK = (1 << n) - 1;
        return dfs(0, n, 0L, 0L, 0L);
    }
    
    private int dfs(int index, int n, long row, long ld, long rd) {
        if (index == n) {
            return 1;
        }
        int count = 0;
        long status = ~(row | ld | rd) & MASK;
        while (status > 0) {
            long pos = status & -status;
            count += dfs(index + 1, n, row | pos, (ld | pos) << 1, (rd | pos) >> 1);
            status -= pos;
        }
        return count;
    }
}