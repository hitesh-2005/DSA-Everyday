class Solution {
    public int count(int m, int n, int mid) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(n, mid / i);
        }
        return cnt;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = count(m, n, mid);
            if (count >= k) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}