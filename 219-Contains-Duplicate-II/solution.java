public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer idx = numToIdx.get(nums[i]);
            if (idx != null && i - idx <= k){
                return true;
            } 
            numToIdx.put(nums[i], i);
        }
        return false;
    }
}