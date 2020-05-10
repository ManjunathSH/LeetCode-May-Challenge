//Given an arbitrary ransom note string and another string containing letters from all the magazines,
//write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//Each letter in the magazine string can only be used once in your ransom note.
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
//
//Constraints:
//You may assume that both strings contain only lowercase letters.

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for(int i = 0; i< magazine.length(); i++)
        {
            Integer count = characterCountMap.get(magazine.charAt(i));
            if(count == null)
                count = 0;
            characterCountMap.put(magazine.charAt(i), ++count);
        }
        
        for(int i = 0; i< ransomNote.length(); i++)
        {
            Integer count = characterCountMap.get(ransomNote.charAt(i));
            if(count == null || count == 0)
                return false;
            characterCountMap.put(ransomNote.charAt(i), --count);
        }
        return true;
    }
}
