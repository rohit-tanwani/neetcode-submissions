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
        Node curr = head;


        Map<Node, Node> originalVsCopyNode = new HashMap<Node, Node>();
        while(curr != null) {
            Node clonedNode = new Node(curr.val);
            originalVsCopyNode.put(curr, clonedNode);
            curr = curr.next;
        }

        curr = head;
        Node newListHead = null;
        while(curr != null) {
            Node clonedRandomNode = originalVsCopyNode.get(curr.random);
            Node clonedNode = originalVsCopyNode.get(curr);
            Node nextClonedNode = originalVsCopyNode.get(curr.next);
            if(newListHead == null) {
                newListHead = clonedNode;
            }
            clonedNode.random = clonedRandomNode;
            clonedNode.next = nextClonedNode;
            curr = curr.next;
        }

        return newListHead;
    }
}
