public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return results;
        }
        Arrays.sort(nums);
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] == prev) {
                continue;
            }
            if (nums[i] * 4 > target) {
                break;
            }
            prev = nums[i];
            int prev2 = Integer.MAX_VALUE;
            int dif = target - nums[i];
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[j] == prev2) {
                    continue;
                }
                if (nums[j] * 3 > dif) {
                    break;
                }
                prev2 = nums[j];
                int newDif = dif - nums[j];
                int low = j + 1;
                int high = n - 1;
                if (nums[low] * 2 > newDif) {
                    break;
                }
                int prevLow = Integer.MAX_VALUE;
                int prevHigh = Integer.MIN_VALUE;
                while (low < high) {
                    if (nums[low] == prevLow) {
                        low++;
                        continue;
                    }
                    if (nums[high] == prevHigh) {
                        high--;
                        continue;
                    }
                    int sum = nums[low] + nums[high];
                    if (sum > newDif) {
                        prevHigh = nums[high];
                        high--;
                    } else if (sum < newDif) {
                        prevLow = nums[low];
                        low++;
                    } else {
                        List<Integer> one = new ArrayList<>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[low]);
                        one.add(nums[high]);
                        results.add(one);
                        prevLow = nums[low];
                        prevHigh = nums[high];
                        low++;
                        high--;
                    }
                }
            }
        }
        return results;
    }
}