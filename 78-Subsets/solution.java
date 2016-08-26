public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int index, int[] nums, List<Integer> crt, List<List<Integer>> res) {
        if (index >= nums.length) {
            return;
        }
        int size = crt.size();
        for (int i = index; i < nums.length; i++) {
            crt.add(nums[i]);
            res.add(new ArrayList<>(crt));
            dfs(i + 1, nums, crt, res);
            crt.remove(size);
        }
    }
}