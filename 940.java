import java.util.HashMap;
import java.util.Map;

// 动态规划
// 元素i在字符串中已经出现过
// dp[i]=dp[i-1]*2-d[t-1]
// t为i元素上一次出现位置
// 元素i在字符串中没有出现过
// dp[i]=dp[i-1]*2+1

class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        index.put(s.charAt(0), 0);

        for(int i = 1; i < n; i ++){
            char ch = s.charAt(i);
            if(index.containsKey(ch)){
                dp[i] = ((dp[i - 1] * 2) % MOD - (index.get(ch) - 1 < 0 ? 0 : dp[index.get(ch) - 1]) % MOD + MOD) % MOD; 
            } else {
                dp[i] = ((dp[i - 1] * 2)  % MOD + 1) % MOD;
            }
            index.put(ch, i);
        }

        return dp[n - 1];
    }
}