class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        // 头节点是专门作为头用
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        // index=0为头节点的下一个节点
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        index = Math.max(0, index);
        size ++;
        ListNode pre = head;
        for(int i = 0; i < index; i ++){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >== size){
            return;
        }
        size --;
        ListNode pre = head;
        for(int i = 0; i < index; i ++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
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