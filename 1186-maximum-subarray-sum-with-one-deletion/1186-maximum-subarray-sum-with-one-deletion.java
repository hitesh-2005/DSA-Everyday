class Solution {
    public int maximumSum(int[] nums) {
        int noDeletionBest = nums[0];
        int oneDeletionBest = 0;
        int res = nums[0];

        for(int i = 1; i<nums.length;i++){
            oneDeletionBest = Math.max(oneDeletionBest+nums[i],noDeletionBest);

            noDeletionBest = Math.max(noDeletionBest+nums[i], nums[i]);

            res = Math.max(res,Math.max(noDeletionBest,oneDeletionBest));
        }
        return res;
    }
}