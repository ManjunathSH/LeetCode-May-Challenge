//You are a product manager and currently leading a team to develop a new product. 
//Unfortunately, the latest version of your product fails the quality check.
//Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which will return whether version is bad. 
//Implement a function to find the first bad version. You should minimize the number of calls to the API.
//
//Example: 
//Given n = 5, and version = 4 is the first bad version.
//
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//
//Then 4 is the first bad version. 

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int mid = n+1/2;
        
        int low = 1;
        int high = n;
        
        while(low<high)
        {
            mid = (low/2) + (high/2);
            mid++; 
            boolean midMinus1 = false;
            if(mid != low)
            {
                midMinus1 = isBadVersion(mid - 1); 
            }
            
            boolean midIsBad = isBadVersion(mid);
        
            if((mid == low  && midIsBad) || (!midMinus1 && midIsBad))
            {
                return mid;
            }
            boolean midPlus1 = isBadVersion(mid + 1);  
            if( midMinus1 )
            {
                high = mid - 1;
            }
            else if ( midPlus1 )
            {
                return mid + 1;
            }
            else 
            {
                low = mid+1;
            }
                
        }
        return 1;
    }
}
