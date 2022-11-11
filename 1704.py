class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = "aeiouAEIOU"
        mid = len(s) // 2
        sum1 = sum(ch in vowels for ch in s[: mid])
        sum2 = sum(ch in vowels for ch in s[mid:])
        return sum1 == sum2