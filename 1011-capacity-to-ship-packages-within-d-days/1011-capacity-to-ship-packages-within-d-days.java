class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int wt : weights){
            low = Math.max(low, wt);
            high += wt;
        }

        while(low <= high){
            int cap = low + (high - low) / 2;
            int currWt = 0;
            int currDays = 1;

            for(int wt : weights){
                if(currWt + wt <= cap){
                    currWt += wt;
                }
                else{
                    currWt = wt;
                    currDays++;
                }
            }

            if(currDays > days){
                low = cap + 1;
            }
            else{
                high = cap - 1;
            }
        }

        return low;
    }
}