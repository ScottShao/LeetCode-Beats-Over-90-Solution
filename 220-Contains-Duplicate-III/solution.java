public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //trivial reject
        if (nums.length < 2) return false;
        if (k == 0 || t < 0) return false;

        int max = nums[0];
        int min = nums[0];

        for (int i : nums)
        {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        // trivial accept
        if (max == min) return true;

        double temp = t;
        temp++;
        
        int length = (int)Math.ceil(((double)max-min)/temp) + 1;
        int[][] table = new int[3][length];

        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            int place =(int) (((double)num - min)/temp);

            if (table[0][place] != 0)
            {
                if (table[1][place] + k >= i)
                    return true;
                else if (place > 0 && table[0][place - 1] == 1 && table[1][place - 1] + k >= i && table[2][place - 1] + t >= num)
                    return true;
                else if (place < length - 1 && table[0][place + 1] == 1 && table[1][place + 1] + k >= i && table[2][place + 1] - t <= num)
                    return true;
            }

            table[0][place] = 1;
            table[1][place] = i;
            table[2][place] = num;
        }
        return false;
    }
}