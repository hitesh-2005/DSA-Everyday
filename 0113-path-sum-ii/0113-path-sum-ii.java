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
    public void helper(TreeNode node, int sum,List<List<Integer>> res, List<Integer> diary,int targetSum){
        if(node == null){
            return;
        }

        sum += node.val;
        diary.add(node.val);

        if(node.left == null && node.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(diary));
                diary.remove(diary.size()-1);
                return;
            }
            
        }

        helper(node.left,sum,res,diary,targetSum);
        helper(node.right,sum,res,diary,targetSum);

        diary.remove(diary.size()-1);
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        helper(root,0,res,diary,targetSum);
        return res;
    }
}