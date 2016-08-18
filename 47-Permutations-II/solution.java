public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
    	perm(result,nums,0,nums.length-1);
    	return result;
    }
    public void perm(List<List<Integer>> result, int[] nums, int start, int end){
    	if(start == end){
    		List<Integer> temp = new ArrayList<>();
    		for(int i : nums) {
    			temp.add(i);
    		}
    		result.add(temp);
    	} else {
    	    Set<Integer> swapped = new HashSet<>();
    		for(int i = start; i <= end; i++) {
    		    if (!swapped.contains(nums[i])) {
        			swap(nums, i, start);
        			perm(result, nums,start+1,end);
        			swap(nums, start, i);
        			swapped.add(nums[i]);
    		    }
    		}
    	}
    }
    
    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}