class Solution {
    public static boolean isValid(int[] have, int[] needed) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < needed[i]) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
        return "";
    
        int low = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int[] have = new int[256];
        int[] needed = new int[256];

        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }
        for (int high = 0; high < s.length(); high++) {
            have[s.charAt(high)]++;

            while (isValid(have, needed)) {
                int len = high - low + 1;
                if (len < minLen) {
                    minLen = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        if (start == -1)
            return "";

        return s.substring(start, start + minLen);
    }
}