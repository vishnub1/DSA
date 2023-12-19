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
    
    static TreeNode prev, first, second;

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        // all logic here 
        if(prev != null && prev.val > root.val) {
            if(first == null) { // first violation
                first = prev;
                second = root;
            } else { // second voilation   (first != null) 
                second = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = first = second = null;

        // inorder traversal
        inorder(root);

        // swaping that voilating nodes values 
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }    
    }
}