# 位运算

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        mask = 0
        ans = 0
        for ch in allowed:
            mask |= 1 << (ord(ch) - ord('a'))
        for word in words:
            mask_w = 0
            for ch in word:
                mask_w |= 1<< (ord(ch) - ord('a'))
            if mask | mask_w == mask:
                ans += 1
        return ans