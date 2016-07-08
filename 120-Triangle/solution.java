public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int size = 1;
        for (List<Integer> row : triangle) {
            int prev = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                int crt = dp[i];
                dp[i] = Math.min(dp[i], prev) + row.get(i);
                prev = crt;
            }
            size++;
        }
        int min = Integer.MAX_VALUE;
        for (int path : dp) {
            min = Math.min(path, min);
        }
        return min;
    }
}