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
        /*Algorithm for the question
            1. We will split the list from middle.
            2. Reverse the second half of list.
            3. Merge the list element of second list with the first one.
        */

       /*1. we can first find the size and then we can do (size / 2) to get the middle element issue with this approach is it will take two loops.
       So we use fast and slow pointer. Fast we increment by two, slow by one so that slow will reach middle of the list when fast finishes the list.*/

       ListNode fast = head;
       ListNode slow = head;
       ListNode prev = null;
       while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //break the list into two parts
       if(prev != null) {
        prev.next = null;
       }

        //reverse the second list 
       ListNode nodeToAdd = reverseList(slow);

        //merging the first part and reversed second part
        ListNode curr = head;
        prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            ListNode nextNodeToAdd = nodeToAdd != null ? nodeToAdd.next : null;

            curr.next = nodeToAdd;
            if(nodeToAdd != null) {
                nodeToAdd.next = next;
            }
            
            prev = curr;
            curr = next;
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
