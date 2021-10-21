class Solution(object):
    def balancedStringSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 栈

        stack = []
        count = 0

        for i in s:
            if len(stack) == 0 or stack[-1] == i:
                stack.append(i)
            else:
                stack.pop()
                if len(stack) == 0:
                    count += 1
        return count

solution = Solution()
count = solution.balancedStringSplit("RRLL")
print(count)