public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null) return 0;
        int len = costs.length;
        if (len == 0) return 0;
        int[][] min = new int[len + 1][3];
        for (int i = 1; i <= len; i++) {
            int t = i - 1;
            min[i][0] = Math.min(min[t][1], min[t][2]) + costs[t][0];
            min[i][1] = Math.min(min[t][0], min[t][2]) + costs[t][1];
            min[i][2] = Math.min(min[t][1], min[t][0]) + costs[t][2];
        }
        return Math.min(min[len][0], Math.min(min[len][1], min[len][2]));
    }
}