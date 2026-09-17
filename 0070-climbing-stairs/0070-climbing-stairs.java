class Solution {
    public static int climbStairs(int n){
        if(n==0 || n==1) return 1;
        int prePrev = 1;
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