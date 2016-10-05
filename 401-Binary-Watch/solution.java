public class Solution {
    private static final int[] BITS = new int[]{1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0) return res;
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = new ArrayList<>();
            List<Integer> mins = new ArrayList<>();
            dfs(0, i, 4, 12, 0, hours);
            dfs(0, num - i, 6, 60, 0, mins);
            for (int hour : hours) {
                for (int min : mins) {
                    res.add(hour + ":" + (min < 10 ? 0 : "") + min);
                }
            }
        }
        return res;
    }
    
    private void dfs(int idx, int num, int bitsIdxBound, int valBound, int crt, List<Integer> res) {
        if (num == 0) res.add(crt);
        else {
            if (crt + BITS[idx] < valBound) dfs(idx + 1, num - 1, bitsIdxBound, valBound, crt + BITS[idx], res);
            if (idx + num < bitsIdxBound) dfs(idx + 1, num, bitsIdxBound, valBound, crt, res);
        }
    }
}