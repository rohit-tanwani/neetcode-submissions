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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    private int goodNodes(TreeNode root, int maxValue) {
        if(root == null) {
            return 0;
        }
        int newMax = Math.max(maxValue, root.val);

    int count = root.val >= maxValue ? 1 : 0;

    return count
         + goodNodes(root.left, newMax)
         + goodNodes(root.right, newMax);
    }
}
