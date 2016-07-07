public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int low;
        int high;
        if (m < n) {
            low = m;
            high = n;
        } else {
            low = n;
            high = m;
        }
        int[] health = new int[low + 1];
        Arrays.fill(health, Integer.MAX_VALUE);
        health[low] = 1;
        for (int i = high - 1; i >= 0; i--) {
            for (int j = low - 1; j >= 0; j--) {
                int temp = m < n ? dungeon[j][i] : dungeon[i][j];
                health[j] = Math.max(Math.min(health[j], health[j + 1]) - temp, 1);
            }
            health[low] = Integer.MAX_VALUE;
        }
        return health[0];
    }
}