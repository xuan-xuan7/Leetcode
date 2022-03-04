// 单调栈
// 计算所有子数组最小值之和和最大值之和
// i位置左边更小位j位置，右边更小位k位置，则i位置为子数组最小值的次数为（k-i）*（i-j）

import java.util.ArrayDeque;
import java.util.Deque;

public class SumofSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        int[] minLeft = new int[len];
        int[] minRight = new int[len];
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        Deque<Integer> minStack = new ArrayDeque<Integer>(); //当一个元素加入时，弹出所有栈顶比它大的元素
        Deque<Integer> maxStack = new ArrayDeque<Integer>();
        for(int i = 0; i < len; i ++){
            while(!minStack.isEmpty() && nums[minStack.peek()] > nums[i]){
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            while(!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]){
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();

        for(int i = len - 1; i >= 0; i --){
            while(!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]){
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? len : minStack.peek();
            minStack.push(i);

            while(!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]){
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? len : maxStack.peek();
            maxStack.push(i);
        }

        long sumMax = 0;
        long sumMin = 0;
        for(int i = 0; i < len; i ++){
            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return sumMax - sumMin;
    }
}
