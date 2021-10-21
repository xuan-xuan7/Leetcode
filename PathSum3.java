// 两种方法
// 1.DFS，注意递归调用的写法，时间复杂度为n^2
// 2.前缀和，纪录root到当前节点的所有前缀节点的路径长度，时间复杂度为n
// 这里采用前缀和的解法，Hashmap纪录路径长度和该长度下的路径条数

import java.util.HashMap;
import java.util.Map;

class TreeNode {
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

public class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        // hashmap不宜作为全局变量，而应该作为参数每次传入dfs，解决左右子树的回溯问题
        HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
        distance.put(0, 1);
        int result = 0;
        result = dfs(root, distance,0, targetSum);
        return result;
    }

    public int dfs(TreeNode root, HashMap<Integer, Integer> distance, int cur, int targetSum){
        int res = 0;
        if(root == null){
            return 0;
        } else {
            cur += root.val;
            res = distance.getOrDefault(cur - targetSum, 0);
            distance.put(cur, distance.getOrDefault(cur, 0) + 1);
            res += dfs(root.left, distance, cur, targetSum);
            res += dfs(root.right, distance, cur, targetSum);
            distance.put(cur, distance.getOrDefault(cur, 0) - 1);
        }
        return res;
    }
}
