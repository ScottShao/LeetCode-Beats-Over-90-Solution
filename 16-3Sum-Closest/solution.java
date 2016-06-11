public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        if (target >= 0 && target - nums[last] * 3 >= 0) {
            return nums[last - 2] + nums[last - 1] + nums[last];
        }
        if (target <= 0 && nums[0] * 3 - target >= 0) {
            return nums[0] + nums[1] + nums[2];
        }
        
        int sign = 1;
        int dif = Integer.MAX_VALUE;
        int crt;
        for (int i = 0; i <= last - 2; i++) {
            if (nums[i] * 3 - target >= dif) {
                break;
            }
            int low = i + 1;
            int high = last;
            while (low < high) {
                crt = nums[i] + nums[low] + nums[high];
                int newDif = crt - target;
                if (newDif < 0) {
                    if (-newDif < dif) {
                        dif = -newDif;
                        sign = -1;
                    }
                    low++;
                } else if (newDif > 0) {
                    if (newDif < dif) {
                        dif = newDif;
                        sign = 1;
                    }
                    high--;
                } else {
                    return target;
                }
            }
        }
        return target + sign * dif;
    }
}