public class Solution {
    private static final int MAXINTDIV10 = Integer.MAX_VALUE / 10;
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        char[] vals = num.toCharArray();
        return dfs(vals, 0, -1L, -1L);
    }
    
    private boolean dfs(char[] vals, int idx, long prev, long pp) {
        int len = vals.length;
        if (idx == len) return true;
        long num = 0;
        for (int i = idx; i < len; i++) {
            char ch = vals[i];
            if (num == 0 && i > idx) break;
            num = num * 10 + ch - '0';
            if (pp == -1 && i + 1 == len) return false; 
            else if ((pp == -1 || pp + prev == num) && dfs(vals, i + 1, num, prev)) return true;
        }
        return false;
    }
}