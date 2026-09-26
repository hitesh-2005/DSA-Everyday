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
    boolean res = false;
    public void helper(TreeNode root, int sum, int targetSum){
        if (root == null){
            return;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res = true;
                return;
            }
        }

        helper(root.left,sum,targetSum);
        helper(root.right,sum,targetSum);
        return;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root,0,targetSum);
        return res;
    }
}