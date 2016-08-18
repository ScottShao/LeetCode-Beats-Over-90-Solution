public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
    	perm(result,nums,0,nums.length-1);
    	return result;
    }
    public static void perm(List<List<Integer>> result, int[] nums, int start, int end){
    	if(start == end){
    		Integer[] ele = new Integer[nums.length];
    		for(int i = 0; i < nums.length; i++) {
    			ele[i] = nums[i];
    		}
    		result.add(Arrays.asList(ele));
    	} else {
    	    Set<Integer> swapped = new HashSet<>();
    		for(int i = start; i <= end; i++) {
    		    if (!swapped.contains(nums[i])) {
        			int temp = nums[start];
        			nums[start] = nums[i];
        			nums[i] = temp;
        			
        			perm(result, nums,start+1,end);
        			
        			temp = nums[start];
        			nums[start] = nums[i];
        			nums[i] = temp;
        			swapped.add(nums[i]);
    		    }
    		}
    	}
    }
}