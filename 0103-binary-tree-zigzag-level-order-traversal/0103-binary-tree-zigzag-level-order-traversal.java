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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int lvlSize = q.size();
            Integer[] temp = new Integer[lvlSize];
            int first = 0;
            int last = lvlSize-1;
            //List<Integer> temp = new ArrayList<>();
            while(lvlSize>0){
                TreeNode node = q.poll();
                if(leftToRight){
                    temp[first] = node.val;
                    first++;
                }
                else{
                    temp[last] = node.val;
                    last--;
                }

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                lvlSize--;
            }
            //Approach- Reversing the list itself if leftToRight is false:
            // if(!leftToRight){
            //     Collections.reverse(temp);
            //     res.add(temp);
            // }
            // else{
            //     res.add(temp);
            // }
            res.add(Arrays.asList(temp));
            leftToRight = !leftToRight;
        }
        return res;
    }
}