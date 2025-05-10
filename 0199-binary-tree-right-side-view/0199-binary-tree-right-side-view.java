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
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i =0; i<level; i++){
                TreeNode element = queue.remove();
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
                if(i == level-1) list.add(element.val);
            }
        }
        return list;
    }
}