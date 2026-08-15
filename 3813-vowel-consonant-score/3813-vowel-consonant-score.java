class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0, score = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch=='a' || ch=='e' || ch=='i'|| ch=='o' || ch=='u'){
                v++;
            }
            else if (ch >= 'a' && ch <= 'z'){
                c++;
            }
        }

        if(c>0){
            score = v/c;
        }
        return score;
    }
}