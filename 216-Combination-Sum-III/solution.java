public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k * 9 < n || k * 1 > n) return res;
        dfs(k, 0, n, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int left, int sum, int n, int start, List<Integer> crt, List<List<Integer>> res) {
        if (sum + left * 9 < n || sum + left * start > n) return;
        int lastIdx = crt.size();
        for (int i = start; i < 10; i++) {
            if (left == 1) {
                List<Integer> temp = new ArrayList<>(crt);
                temp.add(n - sum);
                res.add(temp);
                return;
            } else {
                crt.add(i);
                dfs(left - 1, sum + i, n, i + 1, crt, res);
                crt.remove(lastIdx);
            }
        }
    }
}