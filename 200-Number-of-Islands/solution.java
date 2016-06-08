public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                   count++;
                   bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        if (grid[i][j] <= '0') return;
        grid[i][j] = '#';
        if (i > 0) bfs(grid, i - 1, j);
        if (i < grid.length - 1) bfs(grid, i + 1, j);
        if (j > 0) bfs(grid, i, j - 1);
        if (j < grid[0].length - 1) bfs(grid, i, j + 1);
    }
}