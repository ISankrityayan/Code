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
    private int maxdiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxdiameter;
    }

    private int height(TreeNode node){
        if(node==null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        maxdiameter=Math.max(maxdiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}