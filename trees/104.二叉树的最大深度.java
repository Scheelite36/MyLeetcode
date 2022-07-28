package trees;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // 深度优先 递归
        if (root == null){
            return 0;
        }else{
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax)+1;
        }
    }
}
// @lc code=end

