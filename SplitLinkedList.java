class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SplitLinkedList {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length ++;
            temp = temp.next;
        }
        int m = length % k;
        int n = length / k;
        int t = k - m;

        ListNode[] result = new ListNode[k];
        int i;
        temp = head;
        int count = 0;
        ListNode end = head;
        for(i=0; i<k; i++){
            result[i] = null;
        }
        while(m > 0){
            m --;
            result[count] = temp;
            for(i=0; i<n; i++){
                temp = temp.next;
            }
            end = temp;
            temp = temp.next;
            end.next = null;
            count ++;
        }
        while(k<=length && t > 0){
            t --;
            result[count] = temp;
            for(i=0; i<n-1; i++){
                temp = temp.next;
            }
            end = temp;
            temp = temp.next;
            end.next = null;
            count ++;
        }
        return result;
    }
}
