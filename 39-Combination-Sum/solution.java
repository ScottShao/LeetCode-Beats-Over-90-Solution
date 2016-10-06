public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) return res;
        int len = candidates.length;
        if (len == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] candidates, int idx, int crt, int target, List<Integer> comb, List<List<Integer>> res) {
        if (crt == target) {
            res.add(new ArrayList<>(comb));
        } else {
            if (idx < candidates.length - 1 && candidates[idx] + crt < target) dfs(candidates, idx + 1, crt, target, comb, res);
            comb.add(candidates[idx]);
            if (crt + candidates[idx] <= target) dfs(candidates, idx, crt + candidates[idx], target, comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}