class Solution {
    boolean valid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    public void dfs(int i, int j, int[][] isConnected, boolean[][] visited, int n, int m){
        visited[i][j] = true;
        for(int col = 0; col<m; col++){
            if(valid(j,col,n,m) && isConnected[j][col] == 1 && visited[j][col] == false){
                dfs(j,col,isConnected,visited,n,m);
            }
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(isConnected[i][j] == 1 && visited[i][j] == false){
                    dfs(i,j,isConnected,visited,n,m);
                    res++;
                }
            }
        }
        return res;
    }
}