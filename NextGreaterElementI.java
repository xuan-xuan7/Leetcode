// 单调栈+哈希表
// 单调栈：从后遍历，依次入栈，弹出比入栈元素小的元素

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        int[] re = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
        for(int i=len2-1; i>=0; i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.put(nums2[i], -1);
            } else {
                ans.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++){
            re[i] = ans.get(nums1[i]);
        }

        return re;
    }
}
