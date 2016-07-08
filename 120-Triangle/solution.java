public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];
        int size = len;
        for (int j = len - 1; j >= 0; j--) {
            List<Integer> row = triangle.get(j);
            for (int i = 0; i < size; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + row.get(i);
            }
            size--;
        }
        return dp[0];
    }
}