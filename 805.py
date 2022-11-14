# 动态规划
# 用dp[i][x]表示已经遍历过的元素中能否取出i个元素构成的和为x
# dp[i+1][x+nums[j]]=dp[i][j]
# 剪枝

class Solution:
    def splitArraySameAverage(self, nums: List[int]) -> bool:
        n = len(nums)
        m = n // 2
        s = sum(nums)

        # all()判断迭代中的所有元素是否都为True
        # 剪枝1：如果s * i % n不为整数，那么一定没有i符合条件
        if all(s * i % n for i in range(1, m + 1)):
            return False

        dp = [set() for _ in range(m + 1)]
        dp[0].add(0)
        
        # 遍历nums，计算每次dp的值
        # 将每次该位置上可以得到的值加入dp对应的set()中
        for num in nums:
            for i in range(m, 0, -1):
                for x in dp[i - 1]:
                    curr = x + num
                    if curr * n == s * i:
                        return True
                    dp[i].add(curr)
        
        return False