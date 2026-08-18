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
        int len = 0;

        ListNode pointer = head;
        while(pointer != null) {
            pointer = pointer.next;
            len++;
        }

        int nodeFromStart = len - n;
        pointer = head;
        ListNode prev = null;
        if(nodeFromStart == 0) {
            head = head.next;
            pointer = pointer.next;
        }

        while(pointer != null) {
           nodeFromStart--;
           prev = pointer;
           pointer = pointer.next;

           if(nodeFromStart == 0) {
            if(prev != null && pointer != null) {
                prev.next = pointer.next;
                pointer.next = null;
            }
           }
        }

        return head;
    }
}
