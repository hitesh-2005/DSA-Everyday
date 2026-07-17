class Solution {
   public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int low = 0;
        int maxCount = 0;
        int maxLen = 0;

        for (int high = 0; high < s.length(); high++) {
            freq[s.charAt(high) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(high) - 'A']);
            int len = high-low+1;
            int diff = len - maxCount;

            while (diff > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
                len = high-low+1;
                diff = len-maxCount;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}