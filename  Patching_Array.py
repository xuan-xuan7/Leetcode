from typing import List
import sys


class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        max = 0
        count = 0
        index = 0
        if len(nums) > 0:
            if nums[0] == 1:
                index = index + 1
            else:
                count = count + 1
        else:
            count = count + 1
        max = 1
        while max < n:
            if index < len(nums):
                if nums[index] <= (max + 1):
                    max = max + nums[index]
                    index = index + 1
                else:
                    count = count + 1
                    max = 2 * max + 1
            else:
                count = count + 1
                max = 2 * max + 1
        return count


def main():
    input_list = []
    for line in sys.stdin:
        temp = line.split()
        if len(temp) == 0:
            break
        input_list.extend(temp)
    num = []
    num = eval(input_list[0])
    n = int(input_list[1])
    sol = Solution()
    print(sol.minPatches(num, n))


if __name__ == '__main__':
    main()
