class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n) {
            return -1;
        }

        int low = 1;
        int high = 0;

        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canMake(int[] bloomDay, int m, int k, int days) {
        int flowers = 0;
        int bouquets = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}