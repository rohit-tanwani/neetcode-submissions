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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
           return new ArrayList<Integer>();
        }

        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        
        List<Integer> result = new ArrayList<Integer>();
        while(!levelNodes.isEmpty()) {
            int lastNodeValue = 0;
            List<TreeNode> downLevelNodes = new ArrayList<TreeNode>();
            for(TreeNode node: levelNodes) {
                lastNodeValue = node.val;

                if(node.left != null) {
                    downLevelNodes.add(node.left);
                }

                if(node.right != null) {
                    downLevelNodes.add(node.right);
                }
            }
            result.add(lastNodeValue);
            levelNodes = downLevelNodes;
        }

        return result;
    }
}
