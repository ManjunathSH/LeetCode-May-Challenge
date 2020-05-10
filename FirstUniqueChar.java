//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//Example:
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
//
//You may assume the string contain only lowercase letters.
//

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++)
        {
           Integer count = map.get(s.charAt(i));
           if(count == null)
               count = 0;
            map.put(s.charAt(i), ++count);
               
        }
        for(int i=0; i< s.length(); i++)
        {
            Integer count = map.get(s.charAt(i));
            if(count == 1)
                return i;
        }
        return -1;
    }
}
