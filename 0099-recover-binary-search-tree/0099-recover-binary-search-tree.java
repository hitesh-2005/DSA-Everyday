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
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public void recover(TreeNode root, int first, int second){
        if(root == null){
            return;
        }

        recover(root.left,first,second);
        if(root.val == first){
            root.val = second;
        }
        else if(root.val == second){
            root.val = first;
        }
        recover(root.right,first,second);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int galat = 0;
        int g1First=0, g1Second=0, g2First=0, g2Second=0;
        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                if(galat == 0){
                    g1First = list.get(i);
                    g1Second = list.get(i+1);
                }
                else{
                    g2First = list.get(i);
                    g2Second = list.get(i+1);
                }
                galat++;
            }
        }
        if(galat == 2){
            recover(root,g1First,g2Second);
        }
        else{
            recover(root,g1First,g1Second);
        }
    }
}