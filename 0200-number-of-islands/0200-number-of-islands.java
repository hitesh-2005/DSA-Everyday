class Solution {
    //Direction Arrays for Row and Col and used direction order: {left, right, up, down}
    int[] x = {0,0,-1,1}; 
    int[] y = {-1,1,0,0};

    boolean valid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    public void dfs(int i, int j, char[][] grid, boolean[][] visited, int n, int m){
        visited[i][j] = true;
        for(int k = 0; k<4; k++){
            int row = i + x[k];
            int col = j + y[k];
            if(valid(row,col,n,m) && grid[row][col] == '1' && visited[row][col] == false){
                dfs(row,col,grid,visited,n,m);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(i,j,grid,visited,n,m);
                    res++;
                }
            }
        }
        return res;
    }
}