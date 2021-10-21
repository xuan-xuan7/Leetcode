from typing import List
import sys


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # 维护一个队列，队列单调递减，进入队列的元素会删除队列前面比他小的元素
        end = k
        length = len(nums)
        maxWindow = []
        queue = []
        start = 0
        for i in range(0, end):
            while len(queue) != 0 and nums[i] > queue[-1]:
                queue.pop()
            queue.append(nums[i])
        maxWindow.append(queue[0])
        while end != length:
            end += 1
            if nums[start] == queue[0]:
                queue = queue[1:]
            while len(queue) != 0 and nums[end - 1] > queue[-1]:
                queue.pop()
            start += 1
            queue.append(nums[end - 1])
            maxWindow.append(queue[0])
        return maxWindow


def main():
    input_list = input().split(" ")
    nums = []
    nums = eval(input_list[0])
    k = int(input_list[1])
    sol = Solution()
    window = sol.maxSlidingWindow(nums, k)
    print(window)


if __name__ == '__main__':
    main()
