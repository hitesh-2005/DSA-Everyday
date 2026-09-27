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
//     boolean res = false;
//     public void helper(TreeNode node, int sum, int targetSum){
//         if(node == null){
//             return;
//         }
//         sum += node.val;

//         if(node.left == null && node.right == null){
//             if(sum == targetSum){
//                 res = true;
//                 return;
//             }
//         }

//         helper(node.left,sum,targetSum);
//         helper(node.right,sum,targetSum);
//     }
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         helper(root,0,targetSum);
//         return res;
//     }
// }

class Solution {
    public boolean helper(TreeNode node,int sum,int targetSum){
        if(node == null) return false;

        sum += node.val;

        if(node.left == null && node.right == null){
            return sum == targetSum;
        }

        return helper(node.left,sum,targetSum) || helper(node.right,sum,targetSum);
    }

    public boolean hasPathSum(TreeNode root,int targetSum){
        return helper(root,0,targetSum);
    }
}