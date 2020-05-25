//Return the root node of a binary search tree that matches the given preorder traversal.
//
//(Recall that a binary search tree is a binary tree where for every node, 
//any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  
//Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
//
//Example 1:
//
//Input: [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
//
//Constraints:
//
//1 <= preorder.length <= 100
//1 <= preorder[i] <= 10^8
//The values of preorder are distinct.
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
    
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = null;
        if(preorder.length <= 0)
            return null;
        
        
        if(preorder.length == 1){
            root = new TreeNode(preorder[0]);
            return root;
        }
        else{
            
            int min = 0;
            int max = 100000001;
            
            root = buildBst(preorder, min, max);
        }
        
        return root;
        
    }
    
    TreeNode buildBst( int[] preorder, int min, int max)
    {
        
        if(i >= preorder.length || preorder[i]>max || preorder[i]<min )
            return null;
        
        int curVal = preorder[i];
       
        TreeNode curr = new TreeNode(curVal);
        i++;
        curr.left = buildBst(preorder, min, curVal );
                
        curr.right = buildBst(preorder, curVal,max);
        
        return curr;
        
    }
}
