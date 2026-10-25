
class Solution {
    public void dfs(int vertex, int[][] isConnected, boolean[] visited, int n) {
        visited[vertex] = true;

        for (int col = 0; col < n; col++) {
            if (isConnected[vertex][col] == 1 && !visited[col]) {
                dfs(col, isConnected, visited, n);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false){
                dfs(i, isConnected, visited, n);
                res++;
            }
        }
        return res;
    }
}
