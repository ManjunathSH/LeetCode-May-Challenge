//Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//Note: Do not use any built-in library function such as sqrt.
//
//Input: 16
//Output: true
//
//Input: 14
//Output: false

class Solution {
    public boolean isPerfectSquare(int num) {
             
        int givenNum = num;
        int count = 0;
        while (givenNum > 0)
        {
            givenNum /= 10;
            count++;
        }
        count = (count +1) /2;
        int i = 1;
        for(int k=1 ; k <count ; k++)
        {
            i *= 10;
        }
    
        while(true)
        {
            int prod = i*i;
            
            if(prod == num)
                return true;
            if(prod > num || prod < 0)
               break;
            
            i+= 1000;
        }
        
        i -= 1000;
        while (true)
        {
            int prod = i*i;
            
            if(prod == num)
                return true;
            if(prod > num || prod < 0)
               return false;
            i++;
        }
    }
}
