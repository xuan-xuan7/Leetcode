// 深度优先搜索+中序遍历+双指针

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVBST {
    List<Integer> nodes = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        DFS(root);
        int left = 0;
        int right = nodes.size() - 1;
        while(left < right){
            if(nodes.get(left) + nodes.get(right) == k){
                return true;
            } else if(nodes.get(left) + nodes.get(right) < k){
                left ++;
            } else {
                right --;
            }
        }
        return false;
    }

    public void DFS(TreeNode node){
        if(node == null){
            return;
        }
        DFS(node.left);
        nodes.add(node.val);
        DFS(node.right);
    }
}
