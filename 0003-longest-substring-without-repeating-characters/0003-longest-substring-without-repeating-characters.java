class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character, Integer> lastSeen = new HashMap<>();
        int low = 0;
        int maxLen = 0;
        for (int high = 0; high < s.length(); high++) {
            char current = s.charAt(high);

            if (lastSeen.containsKey(current)) {
                low = Math.max(low, lastSeen.get(current) + 1);
            }
            lastSeen.put(current, high);
            int currLen = high - low + 1;
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}