public class Solution {
    private long MASK;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        MASK = (1 << n) - 1;
        dfs(0, n, 0L, 0L, 0L, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int index, int n, long row, long ld, long rd, List<String> crt, List<List<String>> res) {
        if (index == n) {
            res.add(new ArrayList<>(crt));
            return;
        }
        long status = ~(row | ld | rd) & MASK;
        while (status > 0) {
            long pos = status & -status;
            crt.add(getString(pos, n));
            dfs(index + 1, n, row | pos, (ld | pos) << 1, (rd | pos) >> 1, crt, res);
            crt.remove(index);
            status -= pos;
        }
    }
    
    private String getString(long pos, int n) {
        char[] vals = new char[n];
        int i = n;
        while (pos  > 0) {
            pos >>= 1;
            i--;
        }
        for (int j = 0; j < n; j++) {
            vals[j] = '.'; 
        }
        vals[i] = 'Q';
        return new String(vals);
    }
}