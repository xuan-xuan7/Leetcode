# 记大于8的为1分，小于8的为-1分，转换为求解和大于0的最长区间长度
# 前缀和，对于下标i，找到最小的j满足s[j]<s[i]
# 用哈希表记录每个前缀和第一次出现位置

class Solution:
    def longestWPI(self, hours: list[int]) -> int:
        n = len(hours)
        idx = {}
        s = 0
        ans = 0
        for i in range(n):
            s += 1 if hours[i] > 8 else -1
            # 如果s大于0，说明该前缀符合要求
            if s > 0:
                ans = max(ans, i + 1)
            else:
                # 因为是连续的加减，所以只需要寻找s - 1，这样能够保证是最长的区间
                if s - 1 in idx:
                    ans = max(ans, i - idx[s - 1])
            # 只记录第一次出现位置
            if s not in idx:
                idx[s] = i
        return ans