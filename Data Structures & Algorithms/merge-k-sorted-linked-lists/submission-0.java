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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = head;
        ListNode prev = null;
        
        while(!checkAllNullNodes(lists)) {
            int minIndex = 0;
            int minVal = Integer.MAX_VALUE;
            int currIndex = 0;

            for(ListNode list: lists) {
                if(list != null && list.val < minVal) {
                    minIndex = currIndex; 
                    minVal = list.val;
                    curr = list;
                }
                currIndex++;
            }

            if(head == null) {
                head = curr;
            }
            lists[minIndex] = lists[minIndex].next;
            if(prev != null) {
                prev.next = curr;
            }
            prev = curr;
        }

        return head;
    }

    private boolean checkAllNullNodes(ListNode[] lists) {
        for(ListNode list: lists) {
            if(list != null) {
                return false;
            }
        }

        return true;
    }
}
