import javax.swing.tree.TreeNode;

public class BinaryTreeTilt {
    int slash = 0;

    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        } else{
            countSum(root);
            return slash;
        }
    }

    public void countSum(TreeNode node){
        if(node.left == null && node.right == null){
            slash += 0;
        } else {
            int res = 0;
            if(node.left != null){
                countSum(node.left);
                node.val += node.left.val;
                res += node.left.val;
            }
            if(node.right != null){
                countSum(node.right);
                node.val += node.right.val;
                res -= node.right.val;
            }
            slash += Math.abs(res);
        }
    }
}
