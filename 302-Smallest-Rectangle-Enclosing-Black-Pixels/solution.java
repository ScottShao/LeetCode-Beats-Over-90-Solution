public class Solution {
    private int[] leftTop;
    private int[] rightBot;
    public int minArea(char[][] image, int x, int y) {
        leftTop = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        rightBot = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        dfs(image, x, y);
        return (rightBot[0] - leftTop[0] + 1) * (rightBot[1] - leftTop[1] + 1);
    }
    
    private void dfs(char[][] image, int x, int y) {
        if (image[x][y] == '0') return;
        leftTop[0] = Math.min(leftTop[0], x);
        leftTop[1] = Math.min(leftTop[1], y);
        rightBot[0] = Math.max(rightBot[0], x);
        rightBot[1] = Math.max(rightBot[1], y);
        image[x][y] = '0';
        if (x > 0) dfs(image, x - 1, y);
        if (x < image.length - 1) dfs(image, x + 1, y);
        if (y > 0) dfs(image, x, y - 1);
        if (y < image[0].length - 1) dfs(image, x, y + 1);
    }
}