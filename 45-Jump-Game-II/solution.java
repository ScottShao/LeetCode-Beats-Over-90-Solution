public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] steps = new int[len];
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            int temp = nums[i] + i;
            if (temp > max) {
                int newStep = steps[i] + 1;
                if (temp >= len - 1) {
                    return newStep;
                }
                for (int j = max + 1; j <= temp; j++) {
                    steps[j] = newStep;
                }
                max = temp;
            }
        }
        return steps[len - 1];
    }
}