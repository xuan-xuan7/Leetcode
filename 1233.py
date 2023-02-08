# 字典树 + dfs

class Trie:
    def __init__(self):
        self.children = dict()
        self.ref = -1

class Solution:
    def removeSubfolders(self, folder: list[str]) -> list[str]:
        root = Trie()
        for i, s in enumerate(folder):
            path = s.split('/')
            cur = root
            for node in path:
                if node not in cur.children:
                    cur.children[node] = Trie()
                cur = cur.children[node]
            cur.ref = i

        ans = []
        def dfs(node: Trie()):
            if node.ref != -1:
                ans.append(folder[node.ref])
                return
            else:
                for child in node.children.values():
                    dfs(child)
        dfs(root)
        return ans

if __name__ == '__main__':
    s = Solution()
    source = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
    doc = s.removeSubfolders(source)
    print(doc)