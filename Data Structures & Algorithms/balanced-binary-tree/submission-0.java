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
        return balance(root)[0] == 1;
    }

    public int[] balance(TreeNode root) {
        if(root == null) {
            return new int[]{1,0};
        }
        // if(root.left != null) {
        //     balance(root.left);
        // } 

        // if(root.right != null) {
        //     balance(root.right);
        // }
        int[] left = balance(root.left);
        int [] right = balance(root.right);

        boolean balance = (left[0]==1 && right[0]==1) && (Math.abs(left[1] - right[1]) <= 1);

        return new int[]{(balance ? 1 : 0), Math.max(left[1],right[1]) + 1};    
    }
}
