public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int k, int n, int idx, List<Integer> comb, List<List<Integer>> res) {
        if (k * 9 < n || k * 1 > n) return;
        if (n == 0) {
            res.add(new ArrayList<>(comb));
        } else {
            if (idx < 9) dfs(k, n, idx + 1, comb, res);
            if (idx <= 9) {
                comb.add(idx);
                dfs(k - 1, n - idx, idx + 1, comb, res);
                comb.remove(comb.size() - 1);
            }
        }
    }
}