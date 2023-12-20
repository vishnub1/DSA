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
    
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        // check if the set contains "k - root.val" => if YES - true if NO - False
        if(set.contains(k - root.val)) return true;
        
        // else it add the value to the set
        set.add(root.val);

        // check for the left and right nodes and return ans
        return findTarget(root.left, k) ||  findTarget(root.right,k);
    }
}