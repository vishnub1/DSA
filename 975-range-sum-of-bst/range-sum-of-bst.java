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

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) return 0;

        // using inorder traversal
        // right part 
        if(root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        // add val to sum if it's in range 
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        // right part
        if(root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}