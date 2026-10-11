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
    public void traverse(TreeNode root, HashMap<Integer,Integer> freq){
        if(root == null){
            return;
        }
        traverse(root.left,freq);
        traverse(root.right,freq);
        freq.put(root.val,freq.getOrDefault(root.val,0)+1);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        traverse(root,freq);
        int maxFreq = Integer.MIN_VALUE;
        for(int key : freq.keySet()){
            int count = freq.get(key);

            if(count > maxFreq){
                maxFreq = count;
                res.clear();
                res.add(key);
            }
            else if(count == maxFreq){
                res.add(key);
            }
        }

       int[] arr = new int[res.size()];

        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }

        return arr;
    }
}