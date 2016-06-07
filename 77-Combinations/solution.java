public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfs(int crt, int n, int level, List<Integer> comb, List<List<Integer>> results) {
        if (level == 0) {
            List<Integer> newComb = new ArrayList<>(comb);
            results.add(newComb);
            return;
        }
        int size = comb.size();
        for (int i = crt, max = n - level + 1; i <= max; i++) {
            comb.add(i);
            dfs(i + 1, n, level - 1, comb, results);
            comb.remove(size);
        }
    }
}