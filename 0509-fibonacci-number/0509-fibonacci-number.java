class Solution {
    public static int fib(int n){
        if(n==0 || n==1) return n;
        int prePrev = 0;
        int prev = 1;
        int ans = 0;
        for(int i = 2; i<=n; i++){
            ans = prev + prePrev;
            prePrev = prev;
            prev = ans;
        }
        return ans;
    }
}