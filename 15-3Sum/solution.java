public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> comb = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return comb;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i + 1] * 2 + nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (nums[left] * 2 + nums[i] > 0) {
                    break;
                }
                if (nums[right] * 2 + nums[i] < 0) {
                    break;
                }
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < len - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int s = nums[left] + nums[right] + nums[i];
                if (s > 0) {
                    right--;
                } else if (s < 0) {
                    left++;
                } else {
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[left]);
                    one.add(nums[right]);
                    comb.add(one);
                    left++;
                    right--;
                }
            }
        }
        return comb;
    }
}