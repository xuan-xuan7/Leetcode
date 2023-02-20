class Solution:
    def bestHand(self, ranks: list[int], suits: list[str]) -> str:
        cnt = {}
        ch = suits[0]
        flag = 1
        for s in suits:
            if s != ch:
                flag = 0
                break
        if flag:
            return "Flush"
        maxCount = 1
        for r in ranks:
            if r not in cnt:
                cnt[r] = 1
            else:
                cnt[r] += 1
            maxCount = max(maxCount, cnt[r])
        if maxCount >= 3:
            return "Three of a Kind"
        elif maxCount == 2:
            return "Pair"
        else:
            return "High Card"