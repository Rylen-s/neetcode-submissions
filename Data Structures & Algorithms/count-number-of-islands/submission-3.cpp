class Solution {
    int directions[4][2] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
public:
    
    int numIslands(vector<vector<char>>& grid) {
        int islands = 0;
        int ROWS = grid.size(); int COLS = grid[0].size();
        for(int r = 0 ; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    void bfs(vector<vector<char>>& grid, int row, int col) { 
        queue<pair<int,int>> q;
        q.push({row,col});
        grid[row][col] = '0';
        while(!q.empty()) {
            auto t = q.front();q.pop();
            int r = t.first, c = t.second;

            for(const auto& dir : directions) {
                if(r + dir[0] < 0 || r + dir[0] > grid.size() - 1 || c + dir[1] < 0 || c + dir[1] > grid[0].size() - 1) {
                    continue;
                }
                else if (grid[r + dir[0]][c + dir[1]] == '1'){
                    q.push({r + dir[0],c + dir[1]});
                    grid[r + dir[0]][c + dir[1]] = '0';
                }
            }
        }
    }
};
