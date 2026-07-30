class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] char_Array = new int[26];
        
        for(char c : magazine.toCharArray()) {
            char_Array[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(char_Array[c - 'a'] == 0) return false;
            if(char_Array[c - 'a'] > 0) {
                char_Array[c - 'a']--;
            }
        }
        return true;
    }
}