class Solution {
    public int minSubArrayLen(int target,int[] nums){
        int low = 0,sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int high = 0; high < nums.length; high++){
            sum = sum + nums[high];
            while(sum >= target){
                int currLen = high-low+1;
                minLen = Math.min(minLen,currLen);
                sum = sum - nums[low];
                low++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

}