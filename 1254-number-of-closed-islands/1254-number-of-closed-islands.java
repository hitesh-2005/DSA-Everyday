class Solution {
    int[] x = {0,0,-1,1}; 
    int[] y = {-1,1,0,0};

    boolean valid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    public boolean dfs(int i, int j, int[][] grid, boolean[][] visited, int n, int m){
        visited[i][j] = true;
        boolean closed = true;
        if(i == 0 || i == n-1 || j == 0 || j == m-1){
            closed = false;
        }

        for(int k = 0; k<4; k++){
            int row = i + x[k];
            int col = j + y[k];
            if(valid(row,col,n,m) && grid[row][col] == 0 && visited[row][col] == false){
                boolean res = dfs(row,col,grid,visited,n,m);
                closed = closed && res;
            }
        }
        return closed;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 0 && visited[i][j] == false){
                    if(dfs(i,j,grid,visited,n,m)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}