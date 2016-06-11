public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        
        int dif = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i <= last - 2; i++) {
            if (nums[i] * 3 - target >= dif) {
                break;
            }
            int low = i + 1;
            int high = last;
            while (low < high) {
                int crt = nums[i] + nums[low] + nums[high];
                int newDif = crt - target;
                if (newDif < 0) {
                    if (-newDif < dif) {
                        dif = -newDif;
                        result = crt;
                    }
                    low++;
                } else if (newDif > 0) {
                    if (newDif < dif) {
                        dif = newDif;
                        result = crt;
                    }
                    high--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}