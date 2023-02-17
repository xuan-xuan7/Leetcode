# 动态规划
# 记录四个方向上连续1的数目
# 当前点作为正方形的右下方顶点，考虑左侧和上方的连续1个数，可能的长度一定不会超过两者的最小值
# 只需检测 up[x][y],left[x][y],left[x−l+1][y],up[x][y−l+1]是否大于l


class Solution:
    def largest1BorderedSquare(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        # left和up大小和grid相同，left[i][j]储存的是grid[i-1][j-1]的信息
        left = [[0] * (n + 1) for _ in range(m + 1)]
        up = [[0] * (n + 1) for _ in range(m + 1)]
        maxBorder = 0
        # 遍历每个点
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # 此处其实就是本次操作的点，因为i和j从1开始遍历
                if grid[i - 1][j - 1]:
                    left[i][j] = left[i][j - 1] + 1
                    up[i][j] = up[i - 1][j] + 1
                    border = min(left[i][j], up[i][j])
                    while left[i - border + 1][j] < border or up[i][j - border + 1] < border:
                        border -= 1
                    maxBorder = max(maxBorder, border)
        return maxBorder ** 2
