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
    
    public int helper(TreeNode root, int max, int min) {
        if(root == null) return Integer.MIN_VALUE;

        // Update max and min values seen so far based on the current node's value
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        // Recursively explore left and right subtrees, tracking maximum differences
        int left = helper(root.left, max, min);
        int right = helper(root.right, max, min);

        // Return the maximum difference among:
        // - The difference between the current max and min
        // - The maximum difference found in the left subtree
        // - The maximum difference found in the right subtree
        return Math.max(max - min, Math.max(left, right));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}