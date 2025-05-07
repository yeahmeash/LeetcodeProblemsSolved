/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // If the node is null, the depth is 0
        }
        
        // Recursively find the maximum depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The depth of the current node is 1 (itself) plus the maximum depth of its subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
