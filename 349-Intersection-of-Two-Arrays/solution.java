public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> numSet = new HashSet<>(nums1.length);
        for (int num : nums1) {
            numSet.add(num);
        }
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (numSet.contains(num)) {
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i] = num;
            i++;
        }
        return result;
    }
}