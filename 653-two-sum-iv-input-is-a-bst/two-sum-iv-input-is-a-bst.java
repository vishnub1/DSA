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
    public void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        // Now the list contains inorder traversal values 
        int start = 0;
        int end = list.size()-1;

        while(start < end) {
            int sum = list.get(start) +  list.get(end);

            if(sum < k) {
                start++;
            } else if(sum > k) {
                end--;
            } else {  // sum == k "Found the ans"
                return true;
            }
        }
        return false;  
    }
}