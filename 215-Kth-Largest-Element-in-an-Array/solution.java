public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length - k;
        while (true) {
            int pivot = nums[low];
            int smallerNumIdx = low;
            int largerNumIdx = high;
            int crt = low;
            while (crt <= largerNumIdx) {
                if (nums[crt] < pivot) {
                    swap(nums, crt++, smallerNumIdx++);
                } else if (nums[crt] > pivot) {
                    swap(nums, crt, largerNumIdx--);
                } else {
                    crt++;
                }
            }
            if (index > largerNumIdx) low = largerNumIdx + 1;
            else if (index < smallerNumIdx) high = smallerNumIdx - 1;
            else return pivot;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}