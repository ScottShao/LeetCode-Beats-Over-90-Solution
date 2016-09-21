public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            Integer floor = set.floor(n);
            Integer ceiling = set.ceiling(n);
            if (floor != null && n <= t + floor) return true;
            if (ceiling != null && ceiling <= t + n) return true;
            set.add(n);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}