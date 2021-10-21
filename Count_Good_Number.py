class Solution(object):
    def countGoodNumbers(self, n):
        """
        :type n: int
        :rtype: int
        """
        # 利用数的二进制表示，快速幂

        self.mod = 10**9 + 7

        def quick_mul(x, n):
            res = 1
            while n > 0:
                if n % 2 == 1:
                    res = res * x % self.mod
                x = x * x % self.mod
                n //= 2
            return res

        return quick_mul(5, (n+1) // 2) * quick_mul(4, n // 2) % self.mod

solution = Solution()
print(solution.countGoodNumbers(50))