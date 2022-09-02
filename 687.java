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
    private int maxLength;

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftLength = 0;
        int rightLength = 0;
        if(node.left != null && node.left.val == node.val){
            leftLength = left + 1;
        }
        if(node.right != null && node.right.val == node.val){
            rightLength = right + 1;
        }
        maxLength = Math.max(maxLength, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;

        dfs(root);

        return maxLength;
    }
}