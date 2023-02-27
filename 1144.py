class Solution:
    def movesToMakeZigzag(self, nums: list[int]) -> int:
        ans1 = 0
        ans2 = 0
        for i in range(0, len(nums), 2):
            cnt = 0
            if i - 1 >= 0:
                cnt = max(nums[i] - nums[i - 1] + 1, cnt)
            if i + 1 <= len(nums) - 1:
                cnt = max(nums[i] - nums[i + 1] + 1, cnt)
            ans1 += cnt
        for i in range(1, len(nums), 2):
            cnt = 0
            if i - 1 >= 0:
                cnt = max(nums[i] - nums[i - 1] + 1, cnt)
            if i + 1 <= len(nums) - 1:
                cnt = max(nums[i] - nums[i + 1] + 1, cnt)
            ans2 += cnt    
        return min(ans1, ans2)