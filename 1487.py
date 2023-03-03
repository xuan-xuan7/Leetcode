class Solution:
    def getFolderNames(self, names: list[str]) -> list[str]:
        ans = []
        idx = {}
        for name in names:
            if name not in idx:
                ans.append(name)
                idx[name] = 1
            else:
                i = idx[name]
                while name + '(' + str(i) + ')' in idx:
                    i += 1
                ans.append(name + '(' + str(i) + ')')
                idx[name] = i + 1
                idx[name + '(' + str(i) + ')'] = 1
        return ans