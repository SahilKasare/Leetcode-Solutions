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
        List<List<Integer>> outer = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return outer;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<level; i++){
                TreeNode element = queue.remove();
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
                list.add(element.val);
            }            
            outer.add(list);
        }
        return outer;
    }
}