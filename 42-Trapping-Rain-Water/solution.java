public class Solution {
    public int trap(int[] height){
        int low = 0;
        int high = height.length - 1;
        while (low < high && height[low] <= height[low + 1]) low++;
        while (low < high && height[high] <= height[high - 1]) high--;
        int water = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(low <= high){
            leftmax = Math.max(leftmax,height[low]);
            rightmax = Math.max(rightmax,height[high]);
            if(leftmax < rightmax){
                water += (leftmax - height[low]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                low++;
            } else {
                water += (rightmax - height[high]);
                high--;
            }
        }
        return water;
    }
}