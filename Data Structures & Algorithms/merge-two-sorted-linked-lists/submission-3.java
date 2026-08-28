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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode pointer = null;

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        while(list1 != null && list2 != null) {
            ListNode elem = list1;
            if(list1.val > list2.val) {
                elem = list2;
                list2 = list2.next;
            }
            else {
                elem = list1;
                list1 = list1.next;
            }

            if(pointer == null) {
                pointer = elem;
            }
            else {
                pointer.next = elem;
                pointer = pointer.next;
            }

            if(head == null) {
                head = pointer;
            }
        }

        if(list1 != null) {
            pointer.next = list1;
        }

        if(list2 != null) {
            pointer.next = list2;
        }
        return head;
    }
}