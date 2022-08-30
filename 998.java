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

 // 根据题目意思新添加的val位于构造数组nums的结尾，所以必然是在右子树的位置上


class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode();
        node.val = val;
        TreeNode pre = null;
        TreeNode cur = root;

        while(cur != null && cur.val > val){
            pre = cur;
            cur = cur.right;
        }
        if(pre == null){
            node.left = cur;
            return node;            
        } else {
            pre.right = node;
            node.left = cur;
            return root;
        }
    }
}