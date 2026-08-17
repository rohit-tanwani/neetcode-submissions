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
    public ListNode reverseList(ListNode head) {
        ListNode next = head == null ? null : head.next;
        ListNode prev = head;

        while(next != null) {
           ListNode secondNext = next.next;
           next.next = prev;
           prev = next;
           next = secondNext;
        }
        if(head != null) {
            head.next = null;
        }
        return prev;
    }
}
