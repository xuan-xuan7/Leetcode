import java.util.ArrayDeque;
import java.util.Deque;

// 前缀和
// 双端单调队列
// 使用q存储访问过的前缀和
// 每次访问到某个前缀和preSumArr[j]时，尝试减去q中所有已经访问过的前缀和
// 当q中的前缀和i第一次满足要求时，这个下标i就找到了它满足条件的最短长度，将i从q中移除
// 当前前缀和j减完q中元素时，也需要放入q中，且要把q中比j大的前缀和都删去（满足最短长度原则）
// 由以上增加和删除规律可知：q中加入的元素为当前最大值，q是严格递增的，q中存储下标即可

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        // 记录前缀和
        for(int i = 0; i < n; i ++){
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        // 基于前缀和计算
        for(int i = 0; i <= n; i ++){
            long curSum = preSumArr[i];
            // 从头部开始寻找满足条件的最小长度
            while(!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k){
                res = Math.min(res, i - queue.pollFirst());
            }
            // 从尾部开始剔除比当前前缀和大的队列中元素
            while(!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}