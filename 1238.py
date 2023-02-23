# 类似格雷编码
# 将求出结果的每一项都与start进行按位异或运算

class Solution:
    def circularPermutation(self, n: int, start: int) -> list[int]:
        ans = [start]
        for i in range(1, n + 1):
            for j in range(len(ans) - 1, -1, -1):
                ans.append(((ans[j] ^ start) | (1 << (i - 1))) ^ start)
        return ans