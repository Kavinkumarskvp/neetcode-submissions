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

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null) return null;
        
        map.put(head, new Node(head.val));

        Node current = map.get(head);
        current.next = copyRandomList(head.next);
        current.random = map.get(head.random);

        return current;
    }
}
