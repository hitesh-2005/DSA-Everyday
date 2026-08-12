class Solution {
    public int findLucky(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int lucky = -1;
        for(int key : map.keySet()){
            if(key == map.get(key)){
                lucky = Math.max(lucky,key);
            }
        }
        return lucky;
    }
}