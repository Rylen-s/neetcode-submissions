class Solution {
        public int[][] dp;
        public int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int x, int y, int val) {
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ||  matrix[x][y] <= val)
            return 0;

        if(dp[x][y] != -1) return dp[x][y];
        
        int max = 1;
        for(int[] dir : dirs) {
            max = Math.max(max, dfs(matrix, x + dir[0], y + dir[1], matrix[x][y]) + 1);
        }
        dp[x][y] = max;
        return dp[x][y];
    }
}
