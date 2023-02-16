class Solution:
    def numberOfPairs(self, nums: list[int]) -> list[int]:
        cnt = {}
        ans = [0 for i in range(2)]
        for num in nums:
            if num in cnt:
                cnt[num] += 1
            else:
                cnt[num] = 1
        
        for count in cnt.values():
            ans[0] += count // 2
            ans[1] += count % 2

        return ans
