# 滑动窗口

from collections import Counter


class Solution:
    def balancedString(self, s: str) -> int:
        n = len(s)
        alpha_len = n / 4
        cnt = Counter(s)

        def check():
            if cnt['Q'] > alpha_len or cnt['W'] > alpha_len or cnt['E'] > alpha_len or cnt['R'] > alpha_len:
                return False
            return True

        if check():
            return 0

        ans = len(s)
        r = 0
        for i, c in enumerate(s):
            while r < len(s) and not check():
                cnt[s[r]] -= 1
                r += 1
            if not check():
                break
            ans = min(ans, r - i)
            cnt[c] += 1

        return ans



if __name__ == '__main__':
    s = Solution()
    string = "QREW"
    ans = s.balancedString(string)
    print(ans)
