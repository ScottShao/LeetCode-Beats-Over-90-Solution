public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums1) {
            int[] counter = map.get(num);
            if (counter == null) {
                counter = new int[]{1};
                map.put(num, counter);
            } else {
                counter[0]++;
            }
        }
        
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;
        for (int num : nums2) {
            int[] c = map.get(num);
            if (c != null && c[0] > 0) {
                c[0]--;
                result[count++] = num;
            }
        }
        
        return Arrays.copyOfRange(result, 0, count);
    }
}