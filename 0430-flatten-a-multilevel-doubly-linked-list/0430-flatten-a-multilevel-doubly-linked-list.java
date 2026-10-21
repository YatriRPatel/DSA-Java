/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            
            Node childHead = curr.child;
            Node childTail = childHead;
            
            while (childTail.next != null) {
                childTail = childTail.next;
            }
            
            if (curr.next != null) {
                childTail.next = curr.next;
                curr.next.prev = childTail;
            }
            
            curr.next = childHead;
            childHead.prev = curr;
            curr.child = null;
            
            curr = curr.next;
        }
        
        return head;
    }
}