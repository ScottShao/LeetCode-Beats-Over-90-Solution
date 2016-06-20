public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] * 4 > target) {
                break;
            }
            int dif = target - nums[i];
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] * 3 > dif) {
                    break;
                }
                int newDif = dif - nums[j];
                int low = j + 1;
                int high = n - 1;
                if (nums[low] * 2 > newDif) {
                    break;
                }
                while (low < high) {
                    if ((low > j + 1 && nums[low] == nums[low - 1])) {
                        low++;
                        continue;
                    }
                    if (high < n -1 && nums[high] == nums[high + 1]) {
                        high--;
                        continue;
                    }
                    int sum = nums[low] + nums[high];
                    if (sum > newDif) {
                        high--;
                    } else if (sum < newDif) {
                        low++;
                    } else {
                        List<Integer> one = new ArrayList<>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[low]);
                        one.add(nums[high]);
                        results.add(one);
                        low++;
                        high--;
                    }
                }
            }
        }
        return results;
    }
}