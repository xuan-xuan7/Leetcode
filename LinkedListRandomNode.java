// 水塘抽样法
// 每次random从表头遍历，每个节点产生一个random，若为0则选择

import java.util.Random;

public class LinkedListRandomNode {
    ListNode head;
    Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int ans = 0;
        int i = 1;
        for(ListNode node = head; node != null; node = node.next){
            if(random.nextInt(i) == 0){
                ans = node.val;
            }
            i ++;
        }
        return ans;
    }
}
