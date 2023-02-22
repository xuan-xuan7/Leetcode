# 动态规划 + 记忆化搜索
# dp[i][j]表示剩余[i: len-1]堆时，M=j情况下，能够获得的最多石子数
# 从后向前遍历
# i + 2M >= len，dp[i][M] = sum[i: len-1]
# i + 2M < len，dp[i][M] = max(dp[i][M], sum[i: len-1] - dp[i+x][max(x, M)])

class Solution:
    def stoneGameII(self, piles: list[int]) -> int:
        length = len(piles)
        dp = [[0 for _ in range(length + 1)] for _ in range(length)]
        sum = 0
        for i in range(length - 1, -1, -1):
            sum += piles[i]
            for j in range(1, length + 1):
                if i + 2 * j >= length:
                    dp[i][j] = sum
                else:
                    for x in range(1, 2 * j + 1):
                        dp[i][j] = max(dp[i][j], sum - dp[i + x][max(x, j)])

        return dp[0][1]
