//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note:
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Example 1:
//
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1
//Example 2:
//
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the 
//kth smallest frequently? How would you optimize the kthSmallest routine?
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private boolean flag = false;
    private int smallest = 0;
    public int kthSmallest(TreeNode root, int k) {
        
     getKthSmallestUtil(root,k, 0);
        return smallest;
        
        
    }
    
    public int getKthSmallestUtil(TreeNode root,int k, int count)
    {
       if(flag)
           return 0;
        if(root == null)
            return count;
        int lCount = getKthSmallestUtil(root.left, k, count);
        lCount++;
        if(flag)
            return 0;
        if(k == lCount)
        {
            flag = true;
            smallest = root.val;
            return 0;
        }
        
            
        int rCount = getKthSmallestUtil(root.right, k, lCount);
        return rCount;
        
    }
}
