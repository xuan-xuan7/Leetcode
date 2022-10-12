import java.util.HashSet;
import java.util.Set;

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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> num = new HashSet<>();
        int cnt = 0;

        // use HashSet to store nums
        for(int i = 0; i < nums.length; i ++){
            num.add(nums[i]);
        }

        // use boolean to get prev node state if it is in Set
        boolean inSet = false;
        while(head != null){
            if(!inSet){
                if(num.contains(head.val)){
                    inSet = true;
                    cnt ++;
                }
            } else {
                if(!num.contains(head.val)){
                    inSet = false;
                }
            }
            head = head.next;
        }

        return cnt;
    }
}