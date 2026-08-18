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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pointer = null;
        ListNode head = pointer = new ListNode();
        ListNode prev = null;

        while(l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            if(sum >= 10) {
                carry = 1;
            }
            else {
                carry = 0;
            }

            pointer.val = sum % 10;
            pointer.next = new ListNode();
            prev = pointer;
            pointer = pointer.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry == 0) {
            prev.next = null;
        }
        else {
            pointer.val = carry;
        }
        

        return head;
    }
}
