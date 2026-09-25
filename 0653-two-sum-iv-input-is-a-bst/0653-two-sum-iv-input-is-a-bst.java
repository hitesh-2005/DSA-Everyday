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
    public void printInorder(TreeNode node, List<Integer> list){
        if(node == null) return;

        printInorder(node.left,list);
        list.add(node.val);
        printInorder(node.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        printInorder(root,list);
        
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j) == k){
                return true;
            }
            else if(list.get(i)+list.get(j) < k){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}