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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        else if(root == null || subRoot == null){
            return false;
        }

        if(root.val == subRoot.val) {
            Boolean result = checkForSubtree(root.left, subRoot.left) && checkForSubtree(root.right, subRoot.right);
            if(result) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkForSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        else if(root != null && subRoot != null && root.val == subRoot.val) {
            return checkForSubtree(root.left, subRoot.left) && checkForSubtree(root.right, subRoot.right);
        }
        else {
            return false;
        }
    }
}
