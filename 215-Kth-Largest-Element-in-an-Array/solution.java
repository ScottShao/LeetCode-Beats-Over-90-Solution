public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length - k;
        while (true) {
            int pivot = nums[medianOf3(nums, low, high)];
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
    
    //Use median-of-three strategy to choose pivot
    private int medianOf3(int[] nums, int left, int right) {
        int mid = left + ((right - left) >>> 1);
        if(nums[right] > nums[left])
            swap(nums, left, right);
        if(nums[right] > nums[mid])
            swap(nums, right, mid);
        if(nums[mid] > nums[left])
            swap(nums,left, mid);
        return mid;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}