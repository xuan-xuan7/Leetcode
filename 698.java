import java.util.Arrays;
import java.util.Collections;

// 动态规划 + 状态压缩

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }
        int ave = sum / k;
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n - 1] > ave){
            return false;
        }
        // 二进制状态压缩
        // dp[S]表示在可用数字状态为S的轻卡u能够下是否可能可行
        // S表示当前可用数字集合，每位上0表示可用
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;
        for(int i = 0; i < 1 << n; i ++){
            if(!dp[i]){
                continue;
            }
            // 如果当前状态i可行
            for(int j = 0; j < n; j ++){
                if(curSum[i] + nums[j] > ave){
                    break;
                }
                // 第j位可用
                if(((i << j) & 1) == 0){
                    // 计算下一个状态表示S
                    int next = i | (1 << j);
                    if(!dp[next]){
                        curSum[next] = (curSum[i] + nums[j]) % ave;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}