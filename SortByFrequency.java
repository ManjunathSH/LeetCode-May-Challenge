//Given a string, sort it in decreasing order based on the frequency of characters.
//
//Example 1:
//
//Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//Example 2:
//
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
//Example 3:
//
//Input:
//"Aabb"
//
//Output:
//"bbAa"
//
//Explanation:
//"bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
//

class Solution {
    
    class Pair implements Comparable<Pair>{
        int count;
        char character;
        
        public int compareTo(Pair ob)
        {
            return ob.count-this.count;
        }            
    }
    
    public String frequencySort(String s) {
        Pair[] arr = new Pair[123];
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = new Pair();
        }
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            arr[c].count++;
            arr[c].character = c;
            
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            Pair p = arr[i];
            while(p.count > 0)
            {
                sb.append(p.character);
                p.count--;
            }
        }
        
        return sb.toString();
        
    }
}
