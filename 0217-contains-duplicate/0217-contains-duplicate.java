class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(freq.containsKey(nums[i])){
                return true;
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}