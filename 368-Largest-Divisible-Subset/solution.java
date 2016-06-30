public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<Integer>();
        }
    
        List<List<Integer>> maxList = new ArrayList<List<Integer>>();
        List<Integer> currentList = null;
        List<Integer> best = null;
        List<Integer> result = new ArrayList<Integer>();
    
        Arrays.sort(nums);
    
        for (int i = 0; i < nums.length; i++) {
            currentList = new ArrayList<Integer>();
            best = currentList;
            for (List<Integer> list : maxList) {
                if (((nums[i] % list.get(list.size() - 1)) == 0) 
                     && (list.size() > best.size())) {
                    best = list;
                } 
            }
            currentList.addAll(best);
            currentList.add(nums[i]);
            maxList.add(currentList);
            if (currentList.size() > result.size()) {
                result = currentList;
            }
        }
    
        return result;
    }
}