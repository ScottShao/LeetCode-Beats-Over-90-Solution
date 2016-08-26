public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) { return ans; }
        Arrays.sort(nums);  // non-descending order
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans; 
    }
    
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }
}