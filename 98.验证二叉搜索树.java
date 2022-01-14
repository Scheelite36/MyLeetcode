/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.left != null){
            if(!(root.left.val < root.val)){
                return false;
            }
            isValidBST(root.left);
        } 
        if(root.right != null){
            if(!(root.right.val>root.val)){
                return false;
            }
            isValidBST(root.right);
        }     
        return true;
    }
}
// @lc code=end

