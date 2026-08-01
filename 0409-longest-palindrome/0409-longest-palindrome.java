class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        int res = 0;
        boolean hasOdd = false;
        for(int freq : map.values()){
            if(freq%2 == 0){ 
                res += freq;
            }
            else{
                res += freq-1;
                hasOdd = true;
            }
        }
        if(hasOdd){
            res = res+1;
        }
        return res;
    }
}