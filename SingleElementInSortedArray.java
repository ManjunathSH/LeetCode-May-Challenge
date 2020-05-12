//You are given a sorted array consisting of only integers where every element appears exactly twice,
//except for one element which appears exactly once. Find this single element that appears only once.
//
//Example:
//Input: [1,1,2,3,3,4,4,8,8]
//Output: 2
//
//Input: [3,3,7,7,10,11,11]
//Output: 10
//
//Note: Your solution should run in O(log n) time and O(1) space.
//

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(mid == low){
                return nums[mid];
            }
            //always satisfy the condition of only one element appears once 
            // both low and high will always be even if only one element is repeated
            // can be cleaner if we consider 2*mid and 2*mid+1
            if(mid%2 == 1 && nums[mid-1] == nums[mid])
            {
                low = mid+1;
            }
            else if(mid%2 == 0 && nums[mid-1] != nums[mid])
            {
                low = mid;
            }
            else
            {
                //always satisfy the condition of only one element appears once 
                if(mid%2 == 0)
                    high = mid;
                else
                    high = mid-1;
            }
        }
        return nums[0];
    }
}
