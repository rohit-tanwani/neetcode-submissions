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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return result;
        }
        
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        List<Integer> levelInts = new ArrayList<Integer>();

        while(!levelNodes.isEmpty()) {
            List<TreeNode> downLevelNodes = new ArrayList<TreeNode>();
            for(TreeNode node: levelNodes) {
                levelInts.add(node.val);
                if(node.left != null) {
                    downLevelNodes.add(node.left);
                }

                if(node.right != null) {
                    downLevelNodes.add(node.right);
                }
            }

            result.add(levelInts);
            levelInts = new ArrayList<Integer>();
            levelNodes = downLevelNodes;
        }

        return result;
    }
}
