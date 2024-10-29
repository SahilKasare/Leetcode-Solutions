class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) {
        int r = grid.size();
        int c = grid[0].size();
        vector<vector<int>> new_grid(r,vector<int>(c,-1));
        int max_count = 0;
        for(int i = 0; i<r; i++){
            max_count = max(max_count, maxMoves_helper(i, 0, grid, new_grid));
        }
        return max_count;
    }

    int maxMoves_helper(int r, int c, vector<vector<int>>& grid, vector<vector<int>>& new_grid){
        if(new_grid[r][c] != -1) return new_grid[r][c];

        int maxMoves = 0;
        if(r>0 && c+1<grid[0].size() && grid[r-1][c+1] > grid[r][c])
        maxMoves = max(maxMoves, 1 + maxMoves_helper(r - 1, c + 1, grid, new_grid));
        if(c+1<grid[0].size() && grid[r][c+1] > grid[r][c])
        maxMoves = max(maxMoves, 1 + maxMoves_helper(r, c + 1, grid, new_grid));
        if(r+1<grid.size() && c+1<grid[0].size() &&grid[r+1][c+1] > grid[r][c])
        maxMoves = max(maxMoves, 1 + maxMoves_helper(r + 1, c + 1, grid, new_grid));

        new_grid[r][c] = maxMoves;
        return maxMoves;
    }
};