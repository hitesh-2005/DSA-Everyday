class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnd = nums[0];
        int maxSum = nums[0];
        
        int minEnd = nums[0];
        int minSum = nums[0];
        
        int totalSum = nums[0];
        for(int i=1; i<nums.length; i++){
            totalSum += nums[i];
            maxEnd = Math.max(maxEnd+nums[i],nums[i]);
            maxSum = Math.max(maxSum,maxEnd);

            minEnd = Math.min(minEnd+nums[i],nums[i]);
            minSum = Math.min(minSum,minEnd);

        }
        if(maxSum<0){ 
            return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);
    }
}