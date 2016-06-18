public class Solution {
    
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        int median = findMedium(nums, 0, n - 1, (n + 1) >> 1);
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
 
    private int findMedium(int[] nums, int L, int R, int k) {
        if (L >= R) return nums[R];
        int i = partition(nums, L, R);
        int cnt = i - L + 1;
        if (cnt == k) return nums[i];
        return cnt > k ? findMedium(nums, L, i - 1, k) : findMedium(nums, i + 1, R, k - cnt);
    }
 
    private int partition(int[] nums, int L, int R) {
        int val = nums[L];
        int i = L, j = R + 1;
        while (true) {
            while (++i < R && nums[i] < val) ;
            while (--j > L && nums[j] > val) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, L, j);
        return j;
    }
 
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}