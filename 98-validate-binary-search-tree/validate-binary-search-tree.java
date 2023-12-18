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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTorNot(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTorNot(TreeNode root, long min_boundary, long max_boundary) {
        if(root == null) return true;

        if(root.val <= min_boundary || root.val >= max_boundary) {
            return false;
        }

        return isValidBSTorNot(root.left, min_boundary, root.val) && isValidBSTorNot(root.right, root.val, max_boundary);

    }
}