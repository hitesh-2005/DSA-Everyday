class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int maxFruits = -1;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            int right = fruits[high];
            freq.put(right, freq.getOrDefault(right, 0) + 1);

            while (freq.size() > 2) {
                int left = fruits[low];
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0)
                    freq.remove(left);
                low++;
            }
            int len = high - low + 1;
            maxFruits = Math.max(maxFruits, len);
        }
        return maxFruits;
    }
}