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

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // Reverse the list
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head ==  null || head.next == null) return true;

        // Ste 1 : Find the middle of the ll
        ListNode mid = findMid(head);

        // Step 2 : Reverse the secong half of the list
        ListNode secondHalf = reverseList(mid);

        // Step 3 : Compare the first half with the reversed second half
        ListNode firstHalf = head;
        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // Step 4 : If all nodes matched its a palindrome
        return true;
    }
}