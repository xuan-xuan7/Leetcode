import java.util.ArrayDeque;
import java.util.Deque;

// 动态规划
// s[j][i]表示数组从j到i位置的子数组的最小值
// 对于每个以i为最右的子数组最小值之和dp[i]为s[j][i]的j从0到i的求和
// s[j-1][i] = min(s[j][i], arr[j - 1])
// 若以arr[i]为最右且最小值的最长连续子数组的长度为k
// 有递推公式：dp[i] = dp[i - k] + k * arr[i]
// 通过维护一个单调栈可以知道每个位置上左边第一个比他小的元素的位置


class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        long ans = 0;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] dp = new int[n];

        for(int i = 0; i < n; i ++){
            while(!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]){
                monoStack.pop();
            }
            int k = monoStack.isEmpty() ? (i + 1) : (i - monoStack.peek());
            dp[i] = (monoStack.isEmpty() ? 0 : dp[i - k]) + k * arr[i];
            ans = (ans + dp[i]) % MOD;
            monoStack.push(i);
        }

        return (int)ans;
    }
}