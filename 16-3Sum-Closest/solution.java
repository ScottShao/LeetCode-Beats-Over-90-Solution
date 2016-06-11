public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        int dif = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i <= last - 2; i++) {
            if (nums[i] * 3 - target >= dif) {
                break; //end search early if the minDif is already found
            }
            int low = i + 1;
            int high = last;
            int temp = target - nums[i];
            if (temp - 2 * nums[last] >= 0) {
                temp -= nums[last] + nums[last - 1];
                dif = temp  < dif ? temp : dif;
                result = target - temp;
                continue;
            }
            while (low < high) {
                int crt = nums[i] + nums[low] + nums[high];
                if (target > crt) {
                    if (target - crt < dif) {
                        result = crt;
                        dif = target - crt;
                    }
                    low++;
                } else if (target < crt) {
                    if (crt - target < dif) {
                        result = crt;
                        dif = crt - target;
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