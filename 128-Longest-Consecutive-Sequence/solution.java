public class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums == null || nums.length == 0) {
             return 0;
         }
         Set<Integer> set = new HashSet<>(nums.length);
         Map<Integer, int[]> count = new HashMap<>();
         Set<Integer> visited = new HashSet<>();
         int max = 0;
         for (int num : nums) {
             set.add(num);
         }
         for (int num : nums) {
             if (visited.contains(num)) continue;
             int crt = num;
             while (set.contains(crt)) {
                 visited.add(crt);
                 int[] c = count.get(crt);
                 if (c != null) {
                     int len = c[0] + crt - num;
                     count.put(num, new int[]{len});
                     max = Math.max(max, len);
                     break;
                 } else {
                     crt++;
                 }
             }
             if (!set.contains(crt)) {
                 int len = crt - num;
                 count.put(num, new int[]{len});
                 max = Math.max(len, max);
             }
         }
         return max;
    }
}