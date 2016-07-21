public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        for (int i = 0;i < nums.length - 1;i++){
           nums[i] = nums[i + 1] - nums[i];
           if(nums[i] > 0) {
               nums[i]=1;
           } else if(nums[i] < 0) {
               nums[i] = -1;
           } else {
               nums[i]=0;
           }
        }
        int k = -1;
        int res = 2;
        while (nums[++k] == 0);
        int temp = nums[k];
        for (int i = k;i < nums.length - 2;i++){
            if (nums[i+1] + temp==0){
                temp = nums[i + 1];
                res++;
            }
        }
        return res;
    }
}