public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) return res;
        int len = candidates.length;
        if (len == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] candidates, int idx, int target, List<Integer> comb, List<List<Integer>> res) {
        if (0 == target) {
            res.add(new ArrayList<>(comb));
        } else {
            if (idx < candidates.length - 1) dfs(candidates, idx + 1, target, comb, res);
            if (candidates[idx] <= target) {
                comb.add(candidates[idx]);
                dfs(candidates, idx, target - candidates[idx], comb, res);
                comb.remove(comb.size() - 1);
            }
        }
    }
}