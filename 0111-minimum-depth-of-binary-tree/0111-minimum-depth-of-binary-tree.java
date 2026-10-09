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
    int minDepth = Integer.MAX_VALUE;
    public void helper(TreeNode root, int currDepth){
        if(root == null){
            return;
        }
        currDepth++;
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth,currDepth);
            currDepth = 0;
            return;
        }
        helper(root.left,currDepth);
        helper(root.right,currDepth);
        
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root,0);
        return minDepth;
    }
}