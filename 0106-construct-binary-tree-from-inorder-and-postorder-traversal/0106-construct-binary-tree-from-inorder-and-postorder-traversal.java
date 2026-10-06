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
    int postIdx;
    public TreeNode helper(int[] postorder, HashMap<Integer, Integer> inorderMap,int low, int high){
        if(low > high){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postIdx]);
        postIdx--;

        int inIdx = inorderMap.get(node.val);

        node.right = helper(postorder, inorderMap, inIdx+1, high);
        node.left = helper(postorder, inorderMap, low, inIdx-1);

        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        postIdx = postorder.length-1;

        return helper(postorder, inorderMap, 0, inorder.length-1);
    }
}