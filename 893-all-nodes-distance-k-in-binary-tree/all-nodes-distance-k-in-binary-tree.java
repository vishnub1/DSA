/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parent_tack) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if(currNode.left != null) {
                parent_tack.put(currNode.left, currNode);
                q.add(currNode.left);
            }
            if(currNode.right != null) {
                parent_tack.put(currNode.right, currNode);
                q.add(currNode.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);

        // Traversa radially from the target node 
        // mark visited map     
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int curr_level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if(curr_level == k) break;
            curr_level++;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        // The values in the que is the values at a distance k so return them 
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        
        return ans;
    }
}