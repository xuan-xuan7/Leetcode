// 一次遍历

class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftPos = 0;
        int leftMax = nums[0];
        int curMax = nums[0];

        for(int i = 1; i < nums.length; i ++){
            // 记录已经遍历过的位置内的最大值
            curMax = Math.max(curMax, nums[i]);
            // 如果该位置上的元素小于left中的最大值，则更新left的位置
            if(nums[i] < leftMax){
                leftPos = i;
                leftMax = curMax;
            }
        }

        return leftPos + 1;
    }
}