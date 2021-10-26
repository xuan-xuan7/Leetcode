// 动态规划
// 如果num[i]能被它之前的num[j]整除，则dp[i]=dp[j]+1，dp[j]是最大整数为j的整除子集

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int i, j;
        int maxLen = 1;
        int maxVal = nums[0];
        for(i=0; i<len; i++){
            for(j=i; j>=0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(i=len-1; i>=0 && maxLen>0; i--){
            if(dp[i] == maxLen && maxVal % nums[i] == 0){
                ans.add(nums[i]);
                maxVal = nums[i];
                maxLen --;
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
