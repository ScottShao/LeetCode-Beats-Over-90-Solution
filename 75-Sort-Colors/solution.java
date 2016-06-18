public class Solution {
    public void sortColors(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        int crt = 0;
        while (crt <= blueIdx) {
            if (nums[crt] == 0) {
                swap(nums, crt, redIdx++);
            }else if (nums[crt] == 2){
                swap(nums, crt--, blueIdx--);
            }
            crt++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}