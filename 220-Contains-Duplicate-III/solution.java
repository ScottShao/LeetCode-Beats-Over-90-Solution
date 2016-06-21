public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (set.floor(c) != null && set.floor(c) >= c - t
             || set.ceiling(c) != null && set.ceiling(c) <= c + t) {
                return true;
            } else {
                set.add(c);
                if (i >= k)  set.remove(nums[i - k]);
            }
        }
        return false;
    }
}