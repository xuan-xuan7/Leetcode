import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
    private int deep = 0;
    private int max = 0;
    private Map<Integer, Integer> sum = new HashMap<>();

    private void dfs(TreeNode root, int deep){
        if(deep > max){
            max = deep;
        }
        sum.put(deep, sum.getOrDefault(deep, 0) + root.val);
        if(root.left != null){
            dfs(root.left, deep + 1);
        }
        if(root.right != null){
            dfs(root.right, deep + 1);
        }
        return;
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, deep);
        return sum.get(max);
    }
}