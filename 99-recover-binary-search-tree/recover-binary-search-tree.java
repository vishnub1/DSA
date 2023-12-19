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
    private TreeNode first;   // The first node that violates the BST property
    private TreeNode middle;  // The middle node that violates the BST property
    private TreeNode last;    // The last node that violates the BST property
    private TreeNode prev;    // The previous node during the inorder traversal

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        // check if the current node violates the BST property 
        if(prev != null && (root.val < prev.val)) {
            // first voilation 
            if(first == null) {
                first = prev;
                middle = root;
            } else { // second voilation 
                last = root;
            }
        }

        // set the prev to curr node
        prev = root;
        inorder(root.right);
    }


    public void recoverTree(TreeNode root) {
        first = middle = last = null;

        // initialize prev to a node with the max -ve
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        // swap 
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}