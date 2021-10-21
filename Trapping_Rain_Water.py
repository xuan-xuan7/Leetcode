from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        vol = 0
        left = []
        right = [0 for _ in range(len(height))]
        for i in range(0, len(height)):
            left.append(height[i])
            if i != 0:
                if left[i] < left[i - 1]:
                    left[i] = left[i - 1]
        for i in range(len(height) - 1, -1, -1):
            right[i] = height[i]
            if i != (len(height) - 1):
                if right[i] < right[i + 1]:
                    right[i] = right[i + 1]
        for i in range(0, len(height)):
            vol = vol + min(left[i], right[i]) - height[i]
        return vol


def main():
    height = []
    height = eval(input())
    sol = Solution()
    print(sol.trap(height))


if __name__ == '__main__':
    main()
