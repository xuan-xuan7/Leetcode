import java.util.HashMap;
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
    private Map<Integer, Integer> index;

    private TreeNode getPosition(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        // preorder have no root
        if(preorderLeft > preorderRight){
            return null;
        }
        // first node in preorder is root
        int preorderRoot = preorderLeft;
        // get position in inorder
        int inorderRoot = index.get(preorder[preorderRoot]);
        // establish root node
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // get number of left subTree node 
        int subLeftNum = inorderRoot - inorderLeft;
        root.left = getPosition(preorder, inorder, preorderLeft + 1, preorderLeft + subLeftNum, inorderLeft, inorderRoot - 1);
        root.right = getPosition(preorder, inorder, preorderLeft + subLeftNum + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < inorder.length; i ++){
            index.put(inorder[i], i);
        }
        TreeNode root;
        root = getPosition(preorder, inorder, 0, n - 1, 0, n - 1);
        return root;
    }
}