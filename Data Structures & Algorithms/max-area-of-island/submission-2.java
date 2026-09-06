class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    max = Math.max(max, dfs(row,col,grid));
                }
            }
        }
        return max;
    }

    public int dfs(int r, int c, int[][] g) {
        if(r >= g.length || r < 0 || c < 0 || c >= g[0].length || g[r][c] == 0)
            return 0;

        g[r][c] = 0;

        return 1 + dfs(r,c+1,g) + dfs(r,c-1,g) + dfs(r+1,c,g) + dfs(r-1,c,g); 
    }
}
