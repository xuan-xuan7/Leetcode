# 动态规划
# 上下左右四个方向上分别用k=0,1,2,3表示
# 在每个点(i,j)上用dp[i][j][k]表示该点在该方向上的连续1的数目


class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        dp = [[n] * n for _ in range(n)]
        # 将mines转换为元组
        banned = set(map(tuple, mines))
        # 行遍历，左右
        for i in range(n):
            count = 0
            # 从左到右
            for j in range(n):
                count = 0 if (i, j) in banned else count + 1
                dp[i][j] = min(dp[i][j], count)
            # 从右到左
            count = 0
            for j in range(n - 1, -1 , -1):
                count = 0 if (i, j) in banned else count + 1
                dp[i][j] = min(dp[i][j], count)
        for j in range(n):
            # 从上到下
            count = 0
            for i in range(n):
                count = 0 if (i, j) in banned else count + 1
                dp[i][j] = min(dp[i][j], count)
            # 从下到上
            count = 0
            for i in range(n - 1, -1 , -1):
                count = 0 if (i, j) in banned else count + 1
                dp[i][j] = min(dp[i][j], count)
        # 返回dp中最大值
        return max(map(max, dp))
