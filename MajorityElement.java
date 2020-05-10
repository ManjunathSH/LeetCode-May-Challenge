//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
//
//Example:
//Input: [3,2,3]
//Output: 3
//
//Input: [2,2,1,1,1,2,2]
//Output: 2
//

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++)
        {   
            Integer count = map.get(nums[i]);
            
            if(count == null)
                count = 0;
            map.put(nums[i], ++count);
            if(count > nums.length/2 )
                return nums[i];
        }
        return nums[nums.length -1];
    }
}
