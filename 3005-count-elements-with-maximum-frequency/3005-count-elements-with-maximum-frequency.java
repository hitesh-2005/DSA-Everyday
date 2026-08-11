class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int maxFreq = 0;
        for(int key:map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(key));
        }

        int count = 0;
        for(int key: map.keySet()){
            if(map.get(key) == maxFreq){
                count += maxFreq;
            }
        }
        return count;
    }
}