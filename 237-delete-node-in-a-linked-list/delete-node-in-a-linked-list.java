/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // copy the next node into current node 
        node.val = node.next.val;

        // remove the link from the next node and set it to the node.next
        node.next = node.next.next;
    }
}