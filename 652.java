// 序列化
// 在每个节点上做dfs

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String,Integer> subTree = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    private String dfs(TreeNode node){
        if(node == null){
            return " ";
        }
        StringBuilder str = new StringBuilder();
        str.append(node.val);
        str.append(",");
        str.append(dfs(node.left));
        str.append(dfs(node.right));
        String key = str.toString();
        subTree.put(key, subTree.getOrDefault(key, 0) + 1);
        if(subTree.get(key) == 2){
            ans.add(node);
        }
        return key;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }
}