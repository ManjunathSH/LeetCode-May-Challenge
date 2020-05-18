//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
//In other words, one of the first string's permutations is the substring of the second string.
//
//Example 1:
//
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
//
//Example 2:
//
//Input:s1= "ab" s2 = "eidboaoo"
//Output: False
//
//Note:
//
//The input strings only contain lower case letters.
//The length of both given strings is in range [1, 10,000].
//

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        int len = s1.length();
        for(int i=0; i< s1.length(); i++){
            arr[s1.charAt(i)-'a']++;
        }
        int i = 0;
        int[] arr2 = new int[26];
        for(i=0; i< len && i<s2.length(); i++){
            arr2[s2.charAt(i)-'a']++;
        }
        if(check(arr,arr2))
            return true;
        while (i < s2.length())
        {
            int ind = s2.charAt(i) - 'a';
            arr2[ind]++;
            
            arr2[s2.charAt(i-len)-'a']--;
            if(check(arr,arr2))
                return true;
            i++; 
           
        }
        return false;
    }
    
    public boolean check(int[] a, int[] b)
    {
        for(int i=0; i< 26; i++)
        {
            if(a[i]!= b[i])
                return false;
        }
        return true;
    }
}
