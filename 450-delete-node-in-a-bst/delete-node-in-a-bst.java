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
    // Detete Function
    public TreeNode delete(TreeNode root) {
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        } else {
            // when both left and right child present 
            TreeNode rightChild = root.right; // join with max from left part
            TreeNode maxLeft = maxFromLeft(root.left);
            maxLeft.right = rightChild;
            return root.left;
        }
    }

    public TreeNode maxFromLeft(TreeNode root) {
        if(root.right == null) return root;
        return maxFromLeft(root.right);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            return delete(root);
        }

        TreeNode copy = root; // for returning after delete root 

        while(root != null) {
            if(root.val > key) {
                if(root.left != null && root.left.val == key) {
                    root.left = delete(root.left);
                    break;
                } else {
                    root = root.left; // go deep 
                }
            } else {  //root.val < key
                if(root.right != null && root.right.val == key) {
                    root.right = delete(root.right);
                } else {
                    root = root.right; // go deep
                }
            }
        }
        return copy; // original root
    }
}