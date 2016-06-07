public class Solution {
    public int trap(int[] height){
        int unitSum = 0;
        int sum = 0;
        int top = 0;
        for(int i = 0; i < height.length; i++)
        {
            //in case of re-calculating in the next section;
            if(top < height[i]) //collect only the higher bar;
            {
                sum += unitSum;
                unitSum = 0;
                top = height[i];
            }
            else
                unitSum += top - height[i];
        }
        top = 0;
        unitSum = 0; //reset;
        for(int j = height.length - 1; j >= 0; j--)
        {
            if(top <= height[j]) //collect both the equal and higher bar;
            {
                sum += unitSum;
                unitSum = 0;
                top = height[j];
            }
            else
                unitSum += top - height[j];
        }
        return sum;
    }
}