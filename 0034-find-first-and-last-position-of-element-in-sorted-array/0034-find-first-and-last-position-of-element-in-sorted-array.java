class Solution {
    public int startPos(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] < target){
                low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
    public int endPos(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] < target){
                low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                res = mid;
                low = mid+1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int i = startPos(nums,target);
        int j = endPos(nums,target);
        return new int[]{i,j};
    }
}