public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int redIdx = 0;
        int blueIdx = n - 1;
        int crt = 0;
        while (crt <= blueIdx) {
            if (nums[crt] == 2) {
                swap(nums, crt, blueIdx);
                blueIdx--;
            } else {
                if (nums[crt] == 0) {
                    swap(nums, crt, redIdx);
                    redIdx++;
                }
                crt++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}