class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # 二分查找
        self.nums = nums
        self.n = len(self.nums) - 1
        # print(self.n)
        self.target = target
        self.min = 0

        # if self.target == self.nums[self.min]:
        #     return self.min
        # elif self.target == self.nums[self.n]:
        #     return self.n
        if self.target == self.nums[self.min]:
            return self.min
        if self.target == self.nums[self.n]:
            return self.n
        while True:
            middle = (self.min + self.n) // 2
            # print(self.min, self.n)
            if self.target > self.nums[middle] and self.min != middle:
                self.min = middle
            elif self.target < self.nums[middle] and self.n != middle:
                self.n = middle
            elif self.target == self.nums[middle]:
                return middle
            else:
                break
        return -1

solution = Solution()
index = solution.search([2,5], 5)
print(index)