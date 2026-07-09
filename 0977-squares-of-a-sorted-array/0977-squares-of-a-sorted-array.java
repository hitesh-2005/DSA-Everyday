class Solution {
    public int[] sortedSquares(int[] nums) {
        // int n = nums.length;
        // for(int i = 0; i < n; i++){
        //     nums[i] = nums[i] * nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                neg.add(nums[i]);
            }
            else{
                pos.add(nums[i]);
            }
        }
        int n1 = pos.size();
        int n2 = neg.size();

        if(n1 == 0){ 
            for(int i=0; i<n2; i++){
                neg.set(i, neg.get(i)*neg.get(i));
            }
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray(); 
        }
 
        if(n2 == 0){ 
            for(int i=0; i<n1; i++){
                pos.set(i, pos.get(i)*pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray(); 
        }
        
        for(int i=0; i<n2; i++){
            neg.set(i, neg.get(i)*neg.get(i));
        }
        Collections.reverse(neg);

        for(int i=0; i<n1; i++){
            pos.set(i, pos.get(i)*pos.get(i));
        }

        int res[] = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;    

        while(i<n1 && j<n2){
            if(pos.get(i) <= neg.get(j)){
                res[k++] = pos.get(i++);
            }
            else{
                    res[k++] = neg.get(j++);
            }
        }

        while(i<n1){
            res[k++] = pos.get(i++);
        }

        while(j<n2){
            res[k++] = neg.get(j++);
        }

        return res;
    }
}