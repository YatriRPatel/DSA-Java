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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = head;
        
        while (current != null) {
            while (!stack.isEmpty() && stack.peekLast().val < current.val) {
                stack.removeLast();
            }
            stack.addLast(current);
            current = current.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while (!stack.isEmpty()) {
            tail.next = stack.removeFirst();
            tail = tail.next;
        }
        tail.next = null; 
        
        return dummy.next;
    }
}