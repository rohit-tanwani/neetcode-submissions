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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);

        return Math.abs(rightDepth - leftDepth) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
