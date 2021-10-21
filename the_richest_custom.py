from typing import List


class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max = 0
        for i in range(0, len(accounts)):
            custom = sum(accounts[i])
            if custom > max:
                max = custom
        return max


def main():
    read_in = input()
    accounts = eval(read_in)
    temp = Solution()
    print(temp.maximumWealth(accounts))


if __name__ == '__main__':
    main()
