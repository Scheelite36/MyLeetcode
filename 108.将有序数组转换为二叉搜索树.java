
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int s, int e){
        // 取中间值作为父节点，然后递归分别往左右建立子节点
        if(s > e){
            return null;
        }
        int mid = (s + e) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,s,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,e);
        return root;
    }
}
// @lc code=end

