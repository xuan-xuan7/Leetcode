# dp[i][j][k]表示在第掷筛子i次，掷出为j,且是连续k次的合法序列数

class Solution:
    def dieSimulator(self, n: int, rollMax: list[int]) -> int:
        MOD = 10 ** 9 + 7
        ans = 0
        dp = [[[0 for i in range(16)] for i in range(6)] for i in range(2)]

        for j in range(6):
            dp[1][j][1] = 1
        for i in range(2, n + 1):
            t = i & 1
            for j in range(6):
                for k in range(16):
                    dp[t][j][k] = 0
            for j in range(6):
                for k in range(1, rollMax[j] + 1):
                    for p in range(6):
                        if p != j:
                            dp[t][p][1] += dp[t ^ 1][j][k]
                            dp[t][p][1] = dp[t][p][1] % MOD
                        else:
                            if k + 1 <= rollMax[j]:
                                dp[t][p][k + 1] += dp[t ^ 1][j][k]
                                dp[t][p][k + 1] = dp[t][p][k + 1] % MOD
        
        for j in range(6):
            for k in range(1, rollMax[j] + 1):
                ans += dp[t][j][k]
                ans = ans % MOD
        return ans


if __name__ == '__main__':
    s = Solution()
    n = 2
    rollMax = [1,1,2,2,2,3]
    ans = s.dieSimulator(n, rollMax)
    print(ans)
    