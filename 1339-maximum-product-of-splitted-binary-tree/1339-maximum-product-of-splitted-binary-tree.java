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
    long maxProduct = 0;
    long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        getSubtreeSum(root);
        return (int)(maxProduct % 1_000_000_007);
    }

    public long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    public long getSubtreeSum(TreeNode root) {
        if (root == null) return 0;

        long left = getSubtreeSum(root.left);
        long right = getSubtreeSum(root.right);

        long subtreeSum = root.val + left + right;
        long product = subtreeSum * (totalSum - subtreeSum);

        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
