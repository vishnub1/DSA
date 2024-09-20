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
    public ListNode rotateRight(ListNode head, int k) {
        // edge cases
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        //calculating length
         ListNode temp = head;
         int len = 1;
         while(temp.next != null) {
            len++;
            temp = temp.next;
         }

         //link last node to first node
         temp.next = head;
         k = k % len;    //when k is more than length of list
         k = len - k;   //to get end of the list

         while(k > 0) {
             k--;
             temp = temp.next;
         }

        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
        
    }
}