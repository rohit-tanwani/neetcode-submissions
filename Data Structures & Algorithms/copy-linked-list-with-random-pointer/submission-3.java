/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalVsCopyNode = new HashMap<>();

        Node curr = head;

        // Create copies and mapping
        while (curr != null) {
            originalVsCopyNode.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // Connect next and random pointers
        while (curr != null) {
            Node clonedNode = originalVsCopyNode.get(curr);

            clonedNode.next = originalVsCopyNode.get(curr.next);
            clonedNode.random = originalVsCopyNode.get(curr.random);

            curr = curr.next;
        }

        return originalVsCopyNode.get(head);
    }
}
