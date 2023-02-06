# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        result = self.getBool(root)
        if result == 0:
            return False
        return True

    def getBool(self, node: Optional[TreeNode]) -> int:
        if node.val == 0 or node.val == 1:
            return node.val
        if node.val == 2:
            return self.getBool(node.left) | self.getBool(node.right)
        else:
            return self.getBool(node.left) & self.getBool(node.right)