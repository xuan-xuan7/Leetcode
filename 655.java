import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int height = 0;
    private List<List<String>> ans = new ArrayList<>();

    // get tree's height
    private void calDepth(TreeNode root, int depth){
        if(depth > height){
            height = depth;
        }
        if(root.left != null){
            calDepth(root.left, depth + 1);
        }
        if(root.right != null){
            calDepth(root.right, depth + 1);
        }
        return;
    }

    // dfs insert node value
    private void dfs(TreeNode root, int r, int c){
        ans.get(r).set(c, Integer.toString(root.val));
        if(root.left != null){
            dfs(root.left, r + 1, c - (1 << (height - r - 1)));
        }
        if(root.right != null){
            dfs(root.right, r + 1, c + (1 << (height - r - 1)));
        }
        return;
    }

    public List<List<String>> printTree(TreeNode root) {
        calDepth(root, 0);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;

        // initial List
        for(int i = 0; i < m; i ++){
            List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j ++){
                row.add("");
            }
            ans.add(row);
        }

        dfs(root, 0, (n - 1) / 2);
        return ans; 
    }
}