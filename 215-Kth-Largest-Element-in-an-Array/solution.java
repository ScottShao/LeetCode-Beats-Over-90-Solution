public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length - k;
        while (true) {
            if (low == high) return nums[low];
            int pivot = medianOf3(nums, low, high);
            swap(nums, pivot, high);
            int smallerNumIdx = low;
            int crt = low;
            while (crt < high) {
                if (nums[crt] < nums[high]) {
                    swap(nums, crt, smallerNumIdx++);
                }
                crt++;
            }
            swap(nums, smallerNumIdx, high);
            if (index == smallerNumIdx) {
                return nums[index];
            } else if (index < smallerNumIdx) {
                high = smallerNumIdx - 1;
            } else {
                low = smallerNumIdx + 1;
            }
            
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