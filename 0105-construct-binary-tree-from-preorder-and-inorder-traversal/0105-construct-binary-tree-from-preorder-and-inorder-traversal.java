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
    int preIdx = 0;
    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorderMap,int low, int high){
        if(low > high){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIdx]);
        preIdx++;

        int inIdx = inorderMap.get(node.val);

        node.left = helper(preorder, inorderMap, low, inIdx-1);
        node.right = helper(preorder, inorderMap, inIdx+1, high);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        return helper(preorder,inorderMap,0,inorder.length-1);
    }
}