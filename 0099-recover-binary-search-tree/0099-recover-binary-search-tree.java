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

class Solution{
    TreeNode prev = null;
    TreeNode g1First = null, g1Second = null, g2First = null, g2Second = null;
    int galat = 0;
    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        if(prev == null){
            prev = root;
        }
        else{
            if(root.val<prev.val){
                if(galat == 0){
                    g1First = prev;
                    g1Second = root;
                }
                else{
                    g2First = prev;
                    g2Second = root;
                }
                galat++;
                prev = root;
            }
            else{
                prev = root;
            }
        }
        helper(root.right);
    }
    public void recoverTree(TreeNode root){
        helper(root);
        if(galat == 1){
            int temp = g1First.val;
            g1First.val = g1Second.val;
            g1Second.val = temp;
        }
        else{//(galat == 2)
            int temp = g1First.val;
            g1First.val = g2Second.val;
            g2Second.val = temp;
        }
    }
}
// class Solution {
//     public void inOrder(TreeNode root, List<Integer> list){
//         if(root == null){
//             return;
//         }

//         inOrder(root.left,list);
//         list.add(root.val);
//         inOrder(root.right,list);
//     }
//     public void recover(TreeNode root, int first, int second){
//         if(root == null){
//             return;
//         }

//         recover(root.left,first,second);
//         if(root.val == first){
//             root.val = second;
//         }
//         else if(root.val == second){
//             root.val = first;
//         }
//         recover(root.right,first,second);
//     }
//     public void recoverTree(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inOrder(root,list);
//         int galat = 0;
//         int g1First=0, g1Second=0, g2First=0, g2Second=0;
//         for(int i = 0; i<list.size()-1; i++){
//             if(list.get(i)>list.get(i+1)){
//                 if(galat == 0){
//                     g1First = list.get(i);
//                     g1Second = list.get(i+1);
//                 }
//                 else{
//                     g2First = list.get(i);
//                     g2Second = list.get(i+1);
//                 }
//                 galat++;
//             }
//         }
//         if(galat == 2){
//             recover(root,g1First,g2Second);
//         }
//         else{
//             recover(root,g1First,g1Second);
//         }
//     }
// }