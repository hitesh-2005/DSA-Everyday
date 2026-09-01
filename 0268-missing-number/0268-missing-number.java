class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < nums.length && nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}