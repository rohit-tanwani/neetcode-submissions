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
    public void reorderList(ListNode head) {
        //count list nodes
        int listSize = 0;
        ListNode pointer = head;
        while(pointer != null) {
            pointer = pointer.next;
            listSize++;
        }

        if(listSize <= 2) {
            return;
        }

        //split list after half
        int splitNodeIndex = listSize / 2;

        ListNode prev = null;
        ListNode curr = head;

        while(splitNodeIndex-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        if(prev != null)
            prev.next = null;

        ListNode newListHead = reverseList(curr);

        curr = head;
        ListNode next = curr.next;
        ListNode nodeToAdd = newListHead;
        prev = null;
        while(curr != null) {
            curr.next = nodeToAdd;
            prev = nodeToAdd;
            ListNode nextNodeToAdd = null;
            if(nodeToAdd != null) {
                nextNodeToAdd = nodeToAdd.next;
            }
            
            nodeToAdd.next = next;
            curr = next;
            if(next != null) {
                next = next.next;
            }
            nodeToAdd = nextNodeToAdd;
        }

        if(nodeToAdd != null) {
            prev.next = nodeToAdd;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
