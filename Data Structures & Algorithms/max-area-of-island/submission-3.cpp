class Solution {
public:
    int directions[4][2] = {{0,1},{1,0},{-1,0},{0,-1}};
    
    
    int bfs(vector<vector<int>>& grid, int r, int c) {
        std::queue<pair<int,int>> q;
        grid[r][c] = 0;
        q.push({r,c});
        int area = 1;

        while(!q.empty()) {
            auto it = q.front(); q.pop();
            for(auto& neis : directions) {
                int nr = it.first + neis[0];
                int nc = it.second + neis[1];

                if(nr < 0 || nc < 0 || nr > grid.size() - 1 || nc > grid[0].size() - 1 || grid[nr][nc] == 0) continue;
                q.push({nr, nc});
                grid[nr][nc] = 0;
                area += 1;
            }
        }
        return area;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ROWS = grid.size(), COLS = grid[0].size();
        int max = 0;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    max = std::max(max, bfs(grid, r, c));
                }
            }
        }
        return max;
    }
};
