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
    public void printInOrder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }

        printInOrder(node.left,res);
        res.add(node.val);
        printInOrder(node.right,res);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        printInOrder(root,res);
        for(int i = 1; i<res.size(); i++){
            if(res.get(i-1)>=res.get(i)){
                return false;
            }
        }
        return true;
    }
}