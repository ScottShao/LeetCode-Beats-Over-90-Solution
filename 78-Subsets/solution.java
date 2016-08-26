public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++)
        {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                if (((1 << j) & i) != 0)
                    subset.add(nums[j]);
            }
            subsets.add(subset);
        }
        return subsets; 
    }
    
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }
}