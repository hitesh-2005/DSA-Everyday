class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int digitProduct = 1;
            int i = n;
            while(i != 0){
                int lastDigit = i % 10;
                digitProduct *= lastDigit;
                i = i/10;
            }
            if(digitProduct % t == 0){
                return n;
            }
            else n++;
        }
    }
}