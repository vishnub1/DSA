/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // first approach was simply count size  and size-n+1 node to be delete

        // optimal solution TC-O(n)  SC-O(1);
        ListNode start = new ListNode();
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;

        // first fast ko jane dena hai n times 
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // abhi fast and slow ko +1 step aage jane do jabtak fast == null
        
        while(fast.next != null) {
            fast = fast.next;    // fast at end
            slow = slow.next;    // slow at at n'th point
        }
        
        slow.next = slow.next.next;

        return start.next;   
    }
}