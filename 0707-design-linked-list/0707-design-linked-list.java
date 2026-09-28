class MyLinkedList {
    private class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    private int size;
    private ListNode dummy;

    public MyLinkedList() {
        this.size = 0;
        this.dummy = new ListNode(0);
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode curr = dummy.next;
        for(int i = 0; i < index ; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        size++;
        ListNode pred = dummy;
        for(int i = 0;i<index;i++){
            pred = pred.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pred.next;
        pred.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0||index >= size){
            return;
        }
        size --;
        ListNode pred = dummy;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        
        pred.next = pred.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */