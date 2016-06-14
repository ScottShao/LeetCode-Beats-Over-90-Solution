public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int firstInc = nums[0];
        int firstExc = 0;
        int nonFirstInc = 0;
        int nonFirstExc = 0;

        for(int i = 1; i < nums.length; i++) {
            int preFirstInc = firstInc;
            firstInc = firstExc + nums[i];
            firstExc = Math.max(preFirstInc, firstExc);

            int preNFinc = nonFirstInc;
            nonFirstInc = nonFirstExc + nums[i];
            nonFirstExc = Math.max(preNFinc, nonFirstExc);
        }

        return Math.max(nonFirstInc, firstExc);
    }
    
}