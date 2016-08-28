public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return sets;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), sets);
        return sets;
    }
    
    private void dfs(int[] nums, int index, List<Integer> crt, List<List<Integer>> sets) {
        int size = crt.size();
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i - 1] != nums[i]) {
                crt.add(nums[i]);
                sets.add(new ArrayList<>(crt));
                dfs(nums, i + 1, crt, sets);
                crt.remove(size);
            }
        }
    }
}