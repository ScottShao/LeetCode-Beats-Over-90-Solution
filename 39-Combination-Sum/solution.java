public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return results;
        }
        dfs(0, 0, target, candidates, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(int index, int sum, int target, int[] candidates, List<Integer> comb, List<List<Integer>> results) {
        if (sum == target) {
            results.add(new ArrayList<>(comb));
            return;
        }
        int lastElemIdx = comb.size();
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            int temp = sum + candidates[i];
            if (temp > target) {
                return;
            }
            comb.add(candidates[i]);
            dfs(i, temp, target, candidates, comb, results);
            comb.remove(lastElemIdx);
        }
    }
}