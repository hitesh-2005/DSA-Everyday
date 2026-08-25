class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;

        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;
            }

            if (count >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}