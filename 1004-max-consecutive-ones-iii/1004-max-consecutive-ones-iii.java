class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int zeroes = 0;
        int maxLen = 0;

        for(int high = 0; high<nums.length; high++){
            if(nums[high] == 0){
                zeroes++;
            }

            if(zeroes > k){
                if(nums[low] == 0){
                    zeroes--;
                }
                low++;

            }
            maxLen = Math.max(maxLen, high-low+1);
        }
        return maxLen;

    }
}