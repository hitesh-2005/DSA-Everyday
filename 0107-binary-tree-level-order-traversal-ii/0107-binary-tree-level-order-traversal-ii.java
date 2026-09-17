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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        //Best Approach --> Use LinkedList instead of arraylist becoz it will take O(1) TC in adding the element in the front.
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lvlSize = q.size();
            List<Integer> temp = new ArrayList<>();
            while(lvlSize>0){
                TreeNode node = q.poll();
                temp.add(node.val);

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                lvlSize--;
            }
            //res.add(temp);
            //Approach-2)-> Add new element in the front of the 'res' arraylist
            //res.add(0,temp);
            res.addFirst(temp);
            
        }
        //Approach-1)-> Reverse the 'res' arraylist 
        //Collections.reverse(res);
        return res;
    }
}