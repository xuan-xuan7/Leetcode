# 贪心
# 对于每个点作为左端点时，能够达到的最远右端点

class Solution:
    def minTaps(self, n: int, ranges: list[int]) -> int:
        # 记录每个点的最远右端点
        rightMax = list(range(n + 1))

        # 计算每个左端点能够达到的最远右端点
        for i, r in enumerate(ranges):
            start = max(0 , i - r)
            end = min(i + r, n)
            rightMax[start] = max(rightMax[start], end)

        last = 0
        pre = 0
        cnt = 0
        for i in range(n):
            last = max(last, rightMax[i])
            if i == last:
                return -1
            if i == pre:
                cnt += 1
                pre = last

        return cnt

