class Solution {
    public boolean isVowel(char c){
        char lower = Character.toLowerCase(c);
        if(lower == 'a'||lower == 'e'||lower == 'i'||lower == 'o'||lower == 'u'){
            return true;
        }
        else return false;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(!isVowel(arr[i])){
                i++;
            }
            else if(!isVowel(arr[j])){
                j--;
            }
            else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return new String(arr);
    }
}