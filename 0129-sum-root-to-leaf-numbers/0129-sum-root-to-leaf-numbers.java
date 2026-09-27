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
// class Solution {
//     int allPathSum = 0;
//     public void helper(TreeNode node, int pathSum){
//         if(node == null){
//             return;
//         }
        
//         pathSum = (pathSum * 10)+node.val;

//         if(node.left == null && node.right == null){
//             allPathSum += pathSum;
//         }

//         helper(node.left,pathSum);
//         helper(node.right,pathSum);
//         return;
        
//     }
  
//     public int sumNumbers(TreeNode root) {
//         helper(root,0);
//         return allPathSum;
//     }
// }

class Solution{
    public int helper(TreeNode node, int pathSum){
        if(node == null){
            return 0;
        }

        pathSum = (pathSum*10) + node.val;

        if(node.left == null && node.right == null){
            return pathSum;
        }

        return helper(node.left, pathSum) + helper(node.right, pathSum);
    }
    public int sumNumbers(TreeNode root){
        return helper(root, 0);
    }
}