class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(freq == 0){
                res = nums[i];
                freq = 1;
            }
            else if(nums[i] == res){
                freq++;
            }
            else{
                freq--;
            }
        }
        return res;
    }
}