public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        int size = list.size();
        if (size == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                } else {
                    list.add(nums[i]);
                    used[i] = true;
                    dfs(nums, used, list, res);
                    used[i] = false;
                    list.remove(size);
                }
            }
        }
    }
}