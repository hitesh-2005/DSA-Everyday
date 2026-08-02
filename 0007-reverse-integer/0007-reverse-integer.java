class Solution {
    public int reverse(int x) {
        int revNum = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            int newRev = revNum * 10 + lastDigit;

            if ((newRev - lastDigit) / 10 != revNum) {
                return 0;
            }

            revNum = newRev;
        }

        return revNum;
    }
}
