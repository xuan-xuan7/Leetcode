// 深度优先搜索
// Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}


class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode();
            newRoot.val = val;
            newRoot.left = root;
            return newRoot;
        }
        int cur = 2;
        DFS(root, cur, val, depth);
        return root;
    }

    public void DFS(TreeNode root, int cur, int val, int depth){
        if(cur != depth){
            if(root.left != null){
                DFS(root.left, cur + 1, val, depth);
            }
            if(root.right != null){
                DFS(root.right, cur + 1, val, depth);
            }
            return;
        }
        if(root.left != null){
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            newNode.left = root.left;
            root.left = newNode;
        } else {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            root.left = newNode;
        }
        if(root.right != null){
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            newNode.right = root.right;
            root.right = newNode;
        } else {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            root.right = newNode;
        }
        return;
    }
}