public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] health = new int[n + 1];
        Arrays.fill(health, Integer.MAX_VALUE);
        health[n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                health[j] = Math.max(Math.min(health[j], health[j + 1]) - dungeon[i][j], 1);
            }
            health[n] = Integer.MAX_VALUE;
        }
        return health[0];
    }
}