//We write the integers of A and B (in the order they are given) on two separate horizontal lines.
//
//Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
//
//A[i] == B[j];
//The line we draw does not intersect any other connecting (non-horizontal) line.
//Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
//
//Return the maximum number of connecting lines we can draw in this way.
//
//Example 1:
//
//Input: A = [1,4,2], B = [1,2,4]
//Output: 2
//Explanation: We can draw 2 uncrossed lines as in the diagram.
//We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
//Example 2:
//
//Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
//Output: 3
//Example 3:
//
//Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
//Output: 2
// 
//Note:
//
//1 <= A.length <= 500
//1 <= B.length <= 500
//1 <= A[i], B[i] <= 2000
//
//Used Dynamic programming 2 approaches

class Solution {   
    public int maxUncrossedLines(int[] A, int[] B) {
        int count = 0;
        int i = A.length;
        int j = B.length;
        int[][] dp = new int[i][j];
        for(int k = 0;k< i; k++)
            for(int l = 0; l<j ; l++)
                dp[k][l] = -1;
        count = maxCrosses(A,B,i-1,j-1, dp);
        return count;
    }
    
    public int maxCrosses(int[] A,int[] B,int i,int j, int[][] dp)
    {

        if(i < 0 || j < 0)
        {
            return 0;
        }
        
        if(dp[i][j]!=-1)
            return dp[i][j];
    
        int ans = 0;
        if(A[i] == B[j])
        {  
            ans = maxCrosses(A,B,i-1,j-1,dp) + 1;
        }
        else{
            ans = Math.max(maxCrosses(A,B,i-1,j,dp), maxCrosses(A,B,i,j-1,dp));
        }
        
        dp[i][j] = ans;
        return ans;     
    }  
}

/** class Solution {
*    
*    Map<String, Integer> dp = new HashMap<>();
*    public int maxUncrossedLines(int[] A, int[] B) {
*        int count = 0;
*        int i = A.length;
*        int j = B.length;
*       
*        count = maxCrosses(A,B,i,j);
*        return count;
*    }
*    
*    public int maxCrosses(int[] A,int[] B,int i,int j)
*    {
*        
*        String key = i + ":" + j;
*        Integer val = dp.get(key);
*        if(val!=null)
*            return val;
*        
*        if(i == 0 || j == 0)
*            return 0;
*        
*        int pos = -1;
*        int k = i-1;
*        for(k = i-1; k>=0 ; k--)
*        {
*            pos = find(A[k], B, j);
*            if(pos != -1)
*                break;
*        }
*        int lCount = 0;
*        if(pos!=-1)
*            lCount = maxCrosses(A,B,k,pos) + 1;
*        
*        int rCount = maxCrosses(A,B,i-1,j);
*        
*        int ans = Math.max(lCount,rCount);
*        dp.put(key, ans);
*        return ans;
*        
*        
*    }
*    
*    public int find(int a, int[] B, int j)
*    {
*        
*        for(int i=j-1; i>=0; i--)
*        {
*           if(B[i] == a)
*               return i;
*        }
*        return -1;
*    }
*    
*}
**/
