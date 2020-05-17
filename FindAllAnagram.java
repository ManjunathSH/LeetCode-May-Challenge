//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//The order of output does not matter.
//
//Example 1:
//
//Input:
//s: "cbaebabacd" p: "abc"
//
//Output:
//[0, 6]
//
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//Example 2:
//
//Input:
//s: "abab" p: "ab"
//
//Output:
//[0, 1, 2]
//
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
//

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<>();
        int[] charArray = new int[26];
        int[] sourceArray = new int[26];
        int len = p.length();
        for(int i=0; i<p.length();i++)
        {
            charArray[p.charAt(i)-'a']++;
        }
        int i = 0;
        int j = 0;
        
        while(j<s.length())
        {
            int ind = s.charAt(j)-'a';
            if(charArray[ind] > 0 && sourceArray[ind] < charArray[ind])
            {
                sourceArray[ind]++;
                j++;
                if(j-i == len)
                {
                    index.add(i);
                }
            }
            else{
                if(sourceArray[ind] >= charArray[ind])
                {
                    sourceArray[s.charAt(i)-'a']--;
                    i++;
                }
                else{
                    j++;
                    i=j;
                    Arrays.fill(sourceArray, 0);
                    
                }
            }
            
            if(j-i >= len && i<s.length())
            {
                sourceArray[s.charAt(i)-'a']--;
                i++;
            }
                
        }   
        return index;   
    }
}
