class Solution {
    public int count(int[][] matrix, int n, int mid){
        int row = 0;
        int col = n-1;
        int cnt = 0;
        while(row<n && col>=0){
            if(matrix[row][col] <= mid){
                cnt += col+1;
                row++;
            }
            else{
                col--;
            }
        }
        return cnt;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int res = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int count = count(matrix,n,mid);
            if(count >= k){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}