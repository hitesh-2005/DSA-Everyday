class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }

            String sub = s.substring(0, len);
            StringBuilder str = new StringBuilder();

            while (str.length() < n) {
                str.append(sub);
            }

            if (str.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}