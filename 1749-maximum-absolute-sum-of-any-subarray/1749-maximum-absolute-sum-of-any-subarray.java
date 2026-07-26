class Solution {
    public int maxAbsoluteSum(int[] nums){
        int maxEnd = 0;
        int maxSum = nums[0];

        int minEnd = 0;
        int minSum = nums[0];

        for(int i = 0; i<nums.length; i++){
            maxEnd = Math.max(maxEnd+nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxEnd);

            minEnd = Math.min(minEnd+nums[i], nums[i]);
            minSum = Math.min(minSum, minEnd);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}