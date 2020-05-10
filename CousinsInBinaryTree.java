//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//Return true if and only if the nodes corresponding to the values x and y are cousins.
//
//Input: root = [1,2,3,4], x = 4, y = 3
//               1
//             2  3
//            4
//Output: false
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//                  1
//                2   3
//                 4    5
//Output: true
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//                  1
//                2   3
//                 4
//Output: false 
//
//Note:
//
//The number of nodes in the tree will be between 2 and 100.
//Each node has a unique integer value from 1 to 100.
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

class ParentNode {
    TreeNode parent;
    int depth;    
}
class Solution {
        
    boolean getDepth(TreeNode root,int x, int depth, ParentNode parent){
        
        if (root == null)
            return false;
        
        if(root.val == x){
          parent.depth = depth; 
            return true;
        }
          
        if((root.left!=null && root.left.val == x) || (root.right != null && root.right.val == x))
            parent.parent = root;
        
        boolean isPresentL = getDepth(root.left,x, depth+1, parent);
        
        if(isPresentL)
            return isPresentL;
        
        return getDepth(root.right,x,depth+1, parent);
        
    }
    
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        ParentNode nodeX = new ParentNode();
        ParentNode nodeY = new ParentNode();
        
        boolean isXPresent = getDepth(root, x, 0, nodeX);
        boolean isYPresent = getDepth(root, y, 0, nodeY);
        
        if(isXPresent && isXPresent 
           && nodeX.depth == nodeY.depth
           && nodeX.parent != null && nodeY.parent!= null
           && nodeX.parent.val!= nodeY.parent.val )
            return true;
        else
            return false;
        
    }
}
